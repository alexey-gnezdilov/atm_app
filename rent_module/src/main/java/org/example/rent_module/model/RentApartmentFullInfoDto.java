package org.example.rent_module.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentApartmentFullInfoDto {

    private String city;
    private String street;
    private String houseNumber;
    private String roomsCount;
    private String price;

}
