package org.example.rent_module.mapper;

import org.example.rent_module.entity.AddressInfo;
import org.example.rent_module.entity.ApartmentInfo;
import org.example.rent_module.model.RentApartmentFullInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RentMapper {

    ApartmentInfo rentApartmentRequestDtoToApartmentInfo(RentApartmentFullInfoDto dto);

    @Mapping(source = "apartmentInfo", target = "apartmentInfo")
    @Mapping(target = "id", ignore = true)
    AddressInfo rentApartmentRequestDtoToAddressInfo(RentApartmentFullInfoDto dto, ApartmentInfo apartmentInfo);
}
