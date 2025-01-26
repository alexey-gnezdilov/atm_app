package org.example.rent_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.AddressInfo;
import org.example.rent_module.entity.ApartmentInfo;
import org.example.rent_module.entity.BookingApartment;
import org.example.rent_module.entity.UserPersonalData;
import org.example.rent_module.mapper.RentMapper;
import org.example.rent_module.model.*;
import org.example.rent_module.model.geo_response.GeoResponse;
import org.example.rent_module.repository.AddressInfoRepository;
import org.example.rent_module.repository.BookingRepository;
import org.example.rent_module.repository.UserRepository;
import org.example.rent_module.service.FileService;
import org.example.rent_module.service.RentModuleIntegrationService;
import org.example.rent_module.service.RentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    private final RentModuleIntegrationService rentModuleIntegrationService;
    private final BookingRepository bookingRepository;

    @Override
    public String apartmentRegistration(RentApartmentFullInfoDto dto, MultipartFile file) {
        ApartmentInfo apartmentInfo = rentMapper.rentApartmentRequestDtoToApartmentInfo(dto);
        AddressInfo addressInfo = rentMapper.rentApartmentRequestDtoToAddressInfo(dto, apartmentInfo);
        fileService.buildAndSaveFile(apartmentInfo, file);
        addressInfoRepository.save(addressInfo);
        return APARTMENT_SAVED_MESSAGE;
    }

    @Override
    public List<RentApartmentFullInfoDto> getApartmentFullInfoByLocation(LatitudeAndLongitudeDto coordinates) {
        if (isNull(coordinates.getLatitude()) && isNull(coordinates.getLongitude())) {
            throw new RuntimeException("Lat and Longitude cannot be null");
        }
        GeoResponse geoResponse = rentModuleIntegrationService.requestToGeocoder(coordinates);
        return null;
    }

    @Override
    public BookingRequestApartmentFullInfoDto bookApartment(String token, BookingRequestDto bookingInfo) {

        AddressInfo addressInfo = addressInfoRepository.findById(bookingInfo.getApartmentId()).orElseThrow(RuntimeException::new);

        if (!isNull(token) && !isNull(bookingInfo.getStartDate()) && !isNull(bookingInfo.getEndDate())) {
            UserPersonalData user = userRepository.findByToken(token).orElseThrow(RuntimeException::new);
            if (addressInfo.getApartmentInfo().getAvailability().equals("true")) {
                BookingInfoForProductDto forProduct = rentMapper.toBookingInfoForProductDto(addressInfo, addressInfo.getApartmentInfo(), user, bookingInfo);

                String totalPrice = rentModuleIntegrationService.requestToProductModuleForDiscount(forProduct);
                bookingRepository.save(rentMapper.toBookingApartment(bookingInfo, user, totalPrice));

                addressInfo.getApartmentInfo().setAvailability("false");
                addressInfoRepository.save(addressInfo);

                return rentMapper.toBookingRequestApartmentFullInfoDto(addressInfo, addressInfo.getApartmentInfo(),"Апартаменты успешно зарезервированы", totalPrice);
            }
        }

        return rentMapper.toBookingRequestApartmentFullInfoDto(addressInfo, addressInfo.getApartmentInfo(),"Чтобы забронировать апартаменты, войдите в систему! Или возможно, что апартаменты сейчас не доступны для бронирования.");
    }
}
