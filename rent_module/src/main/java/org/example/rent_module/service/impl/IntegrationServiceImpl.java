package org.example.rent_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.IntegrationInfo;
import org.example.rent_module.model.LatitudeAndLongitudeDto;
import org.example.rent_module.model.geo_response.GeoResponse;
import org.example.rent_module.repository.IntegrationInfoRepository;
import org.example.rent_module.service.IntegrationService;
import org.example.rent_module.util.Base64EncodeDecode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private static final String GEO = "GEO";

    private final RestTemplate restTemplate;
    private final IntegrationInfoRepository infoRepository;

//    public IntegrationServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Override
    public String requestToProductModule() {
        return restTemplate.exchange(
                "http://localhost:8084/get_version",
                HttpMethod.GET,
                new HttpEntity<>(null,buildHeadersToRequest()),
                String.class
        ).getBody();
    }

    @Override
    public GeoResponse requestToGeocoder(LatitudeAndLongitudeDto coordinates) {
        return restTemplate.exchange(
                prepareGeoPath(coordinates),
                HttpMethod.GET,
                new HttpEntity<>(null,null),
                GeoResponse.class
        ).getBody();
    }

    private HttpHeaders buildHeadersToRequest(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", "testToken");
        return httpHeaders;
    }

    private String prepareGeoPath(LatitudeAndLongitudeDto coordinates) {
        IntegrationInfo integrationInfo = infoRepository.findById(GEO).get();
        return String.format(integrationInfo.getPath(),
                coordinates.getLatitude(),
                coordinates.getLongitude(),
                Base64EncodeDecode.decoder(integrationInfo.getKey()));
    }
}
