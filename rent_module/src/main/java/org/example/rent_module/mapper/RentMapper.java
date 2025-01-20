package org.example.rent_module.mapper;

import org.example.rent_module.entity.AddressInfo;
import org.example.rent_module.entity.ApartmentInfo;
import org.example.rent_module.entity.UserPersonalData;
import org.example.rent_module.model.BookingInfoForProductDto;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.example.rent_module.constants.RentApartmentConstants.*;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RentMapper {

    ApartmentInfo rentApartmentRequestDtoToApartmentInfo(RentApartmentFullInfoDto dto);

    @Mapping(source = APARTMENT_INFO_MAPPING, target = APARTMENT_INFO_MAPPING)
    @Mapping(target = ID_COLUMN, ignore = true)
    AddressInfo rentApartmentRequestDtoToAddressInfo(RentApartmentFullInfoDto dto, ApartmentInfo apartmentInfo);

    @Mapping(target = REGISTRATION_DATE, ignore = true)
    BookingInfoForProductDto toBookingInfoForProductDto(AddressInfo addressInfo, ApartmentInfo apartmentInfo, UserPersonalData user);
}
