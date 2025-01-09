package org.example.rent_module.controller;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.example.rent_module.service.CheckTokenSessionService;
import org.example.rent_module.service.RentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.example.rent_module.constants.RentApartmentConstants.*;

@RestController
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;
    private final CheckTokenSessionService checkTokenSessionService;

    @PostMapping(REGISTRATION_APARTMENT_URL)
    public String apartmentRegistration(
            @RequestHeader(required = true) String token,
            @RequestPart(value = APARTMENT_INFO_REQUEST_PART, required = true) RentApartmentFullInfoDto apartmentInfo,
            @RequestPart(value = FILE_REQUEST_PART,required = false) MultipartFile file) {
        checkTokenSessionService.checkToken(token);
        return rentService.apartmentRegistration(apartmentInfo, file);
    }

    @GetMapping(CHOOSE_DISCOUNT_URL)
    public String chooseDiscount(String idRent){
        return rentService.chooseDiscount(idRent);
    }


    @PostMapping(APARTMENTS_BY_LOCATION_URL)
    public List<RentApartmentFullInfoDto> getApartmentFullInfoByLocation(@RequestBody LatitudeAndLongitudeDto coordinates){
        return rentService.getApartmentFullInfoByLocation(coordinates);
    }
}
