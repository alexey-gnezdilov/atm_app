package com.example.product_module.model;

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
    private LocalDateTime registrationDate;

}
