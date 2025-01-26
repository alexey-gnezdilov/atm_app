package org.example.rent_module.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingInfoForProductDto {

    private String city;
    private String street;
    private String houseNumber;
    private String roomsCount;
    private String price;
    private String message;
    private String login;
    private String email;
    private String userCityFrom;
    private LocalDateTime addressRegistrationDate;
    private LocalDateTime userRegistrationDate;
    private LocalDateTime birthDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int bookingAmount;
    private String promocode;
    private boolean foreignCitizen;
    private boolean byCash;
}
