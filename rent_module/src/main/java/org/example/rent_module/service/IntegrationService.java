package org.example.rent_module.service;

import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.geo_response.GeoResponse;

public interface IntegrationService {

    String requestToProductModule();
    GeoResponse requestToGeocoder(LatitudeAndLongitudeDto coordinates);

}
