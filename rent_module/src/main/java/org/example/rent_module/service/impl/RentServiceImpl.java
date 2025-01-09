package org.example.rent_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.AddressInfo;
import org.example.rent_module.entity.ApartmentInfo;
import org.example.rent_module.mapper.RentMapper;
import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.example.rent_module.model.geo_response.GeoResponse;
import org.example.rent_module.repository.AddressInfoRepository;
import org.example.rent_module.service.FileService;
import org.example.rent_module.service.IntegrationService;
import org.example.rent_module.service.RentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.Objects.isNull;
import static org.example.rent_module.constants.RentApartmentConstants.APARTMENT_SAVED;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final AddressInfoRepository addressInfoRepository;
    private final FileService fileService;
    private final RentMapper rentMapper;
    private final IntegrationService integrationService;

    @Override
    public String apartmentRegistration(RentApartmentFullInfoDto dto, MultipartFile file) {
        ApartmentInfo apartmentInfo = rentMapper.rentApartmentRequestDtoToApartmentInfo(dto);
        AddressInfo addressInfo = rentMapper.rentApartmentRequestDtoToAddressInfo(dto, apartmentInfo);
        fileService.buildAndSaveFile(apartmentInfo, file);
        addressInfoRepository.save(addressInfo);
        return APARTMENT_SAVED;
    }

    @Override
    public String chooseDiscount(String idRent) {
        return integrationService.requestToProductModule();
    }

    @Override
    public List<RentApartmentFullInfoDto> getApartmentFullInfoByLocation(LatitudeAndLongitudeDto coordinates) {
        if (isNull(coordinates.getLatitude()) && isNull(coordinates.getLongitude())) {
            throw new RuntimeException("Lat and Longitude cannot be null");
        }
        GeoResponse geoResponse = integrationService.requestToGeocoder(coordinates);
        return null;
    }
}
