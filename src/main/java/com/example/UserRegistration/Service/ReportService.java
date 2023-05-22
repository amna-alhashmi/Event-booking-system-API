package com.example.UserRegistration.Service;

import com.example.UserRegistration.DTO.ReportEventBookingSystem;
import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.TicketBooking;
import com.example.UserRegistration.Models.UserRegistration;
import com.example.UserRegistration.Repositories.EventInterface;
import com.example.UserRegistration.Repositories.TicketBookingInterface;
import com.example.UserRegistration.Repositories.UserRegistrationInterface;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    UserRegistrationInterface userRegistrationInterface;
    @Autowired
    EventInterface eventInterface;
    @Autowired
    TicketBookingInterface ticketBookingInterface;
    public static final String pathToReports = "C:\\Users\\user008\\Downloads\\report";
    public String getReportForEventBookingSystem() throws FileNotFoundException, JRException {
        List<TicketBooking> ticketBookingList = ticketBookingInterface.getAllTicketBooking();
        List<ReportEventBookingSystem> reportEventBookingSystemArrayList = new ArrayList<>();

        for (TicketBooking ticketBooking : ticketBookingList) {
            Integer totalBooking = ticketBookingInterface.getTotalNumberOfBooking();
            String eventName = ticketBooking.getEvent().getName();
            Integer booking = eventInterface.getEventBooking();
            String userName=ticketBooking.getEvent().getUserRegistration().getUserName();
            Integer userBooking= userRegistrationInterface.getUserBooking();


            ReportEventBookingSystem EventBookingDTO = new ReportEventBookingSystem(totalBooking, eventName, booking,userName,userBooking);
            reportEventBookingSystemArrayList.add(EventBookingDTO);
        }
        File file = new File("C:\\Users\\user008\\Desktop\\Task 8\\RESTfull-APIs\\src\\main\\resources\\ReportEventBookingSystem.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportEventBookingSystemArrayList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\ReportEventBookingSystem.pdf");
        return "Report generated : " + pathToReports + "\\ReportEventBookingSystem.pdf";
    }
}
