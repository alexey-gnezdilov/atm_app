package org.example.rent_module.service;

import org.example.rent_module.model.BookingInfoForProductDto;
import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.geo_response.GeoResponse;

public interface RentModuleIntegrationService {

    String requestToProductModule();
    String requestToProductModuleForDiscount(BookingInfoForProductDto info);
    GeoResponse requestToGeocoder(LatitudeAndLongitudeDto coordinates);

}
