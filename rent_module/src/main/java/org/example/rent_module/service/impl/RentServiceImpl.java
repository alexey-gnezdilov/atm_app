package org.example.rent_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.AddressInfo;
import org.example.rent_module.entity.ApartmentInfo;
import org.example.rent_module.entity.UserPersonalData;
import org.example.rent_module.mapper.RentMapper;
import org.example.rent_module.model.BookingInfoForProductDto;
import org.example.rent_module.model.BookingRequestApartmentFullInfoDto;
import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.example.rent_module.model.geo_response.GeoResponse;
import org.example.rent_module.repository.AddressInfoRepository;
import org.example.rent_module.repository.UserRepository;
import org.example.rent_module.service.FileService;
import org.example.rent_module.service.IntegrationService;
import org.example.rent_module.service.RentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;
import static org.example.rent_module.constants.RentApartmentConstants.APARTMENT_SAVED_MESSAGE;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final AddressInfoRepository addressInfoRepository;
    private final UserRepository userRepository;
    private final FileService fileService;
    private final RentMapper rentMapper;
    private final IntegrationService integrationService;

    @Override
    public String apartmentRegistration(RentApartmentFullInfoDto dto, MultipartFile file) {
        ApartmentInfo apartmentInfo = rentMapper.rentApartmentRequestDtoToApartmentInfo(dto);
        AddressInfo addressInfo = rentMapper.rentApartmentRequestDtoToAddressInfo(dto, apartmentInfo);
        fileService.buildAndSaveFile(apartmentInfo, file);
        addressInfoRepository.save(addressInfo);
        return APARTMENT_SAVED_MESSAGE;
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

    @Override
    public BookingRequestApartmentFullInfoDto bookApartment(String token, Long idApartment, LocalDateTime start, LocalDateTime end) {
        BookingRequestApartmentFullInfoDto requestApartmentFullInfoDto = new BookingRequestApartmentFullInfoDto();
        AddressInfo addressInfo = addressInfoRepository.findById(idApartment).orElseThrow(RuntimeException::new);

        if (!isNull(token) && !isNull(start) && !isNull(end)) {
            UserPersonalData userPersonalData = userRepository.findByToken(token).orElseThrow(RuntimeException::new);
            if (addressInfo.getApartmentInfo().getAvailability().equals("true")) {
                //TODO создать таблицу booking_apartment (id, user_id, apartment_id, start_date, end_date, product_id)
                BookingInfoForProductDto forProduct = rentMapper.toBookingInfoForProductDto(addressInfo, addressInfo.getApartmentInfo(), userPersonalData);
                integrationService.requestToProductModuleForDiscount(forProduct);
            }
        }

        requestApartmentFullInfoDto.setMessage("Чтобы забранировать апартаменты, войдите в систему!");
        requestApartmentFullInfoDto.setCity(addressInfo.getCity());
        requestApartmentFullInfoDto.setStreet(addressInfo.getStreet());
        requestApartmentFullInfoDto.setPrice(addressInfo.getApartmentInfo().getPrice());
        requestApartmentFullInfoDto.setRoomsCount(addressInfo.getApartmentInfo().getRoomsCount());
        requestApartmentFullInfoDto.setHouseNumber(addressInfo.getHouseNumber());

        return requestApartmentFullInfoDto;
    }
}
