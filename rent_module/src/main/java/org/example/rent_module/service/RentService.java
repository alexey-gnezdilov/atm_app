package org.example.rent_module.service;

import org.example.rent_module.model.BookingRequestApartmentFullInfoDto;
import org.example.rent_module.model.BookingRequestDto;
import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface RentService {
    String apartmentRegistration(RentApartmentFullInfoDto apartmentInfo, MultipartFile file);
    List<RentApartmentFullInfoDto> getApartmentFullInfoByLocation(LatitudeAndLongitudeDto coordinates);
    BookingRequestApartmentFullInfoDto bookApartment(String token, BookingRequestDto bookingInfo);
}
