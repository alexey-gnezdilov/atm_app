package org.example.rent_module.service;

import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RentService {
    String apartmentRegistration(RentApartmentFullInfoDto apartmentInfo, MultipartFile file);
    String chooseDiscount(String idRent);
    List<RentApartmentFullInfoDto> getApartmentFullInfoByLocation(LatitudeAndLongitudeDto coordinates);
}
