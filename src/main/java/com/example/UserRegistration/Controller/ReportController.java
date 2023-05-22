package com.example.UserRegistration.Controller;

import com.example.UserRegistration.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value = "reportForEventBookingSystem",method = RequestMethod.GET)

    public void getReportForEventBookingSystem(@RequestParam String eventName,String userName) throws Exception{

        reportService.getReportForEventBookingSystem(eventName,userName);
    }
}
