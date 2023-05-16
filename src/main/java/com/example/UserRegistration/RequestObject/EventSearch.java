package com.example.UserRegistration.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class EventSearch {
    Integer id;
    String name;
    String location;
    String dateFrom;
    String dateTo;
}
