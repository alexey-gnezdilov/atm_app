package org.example.rent_module.model.geo_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static org.example.rent_module.constants.RentApartmentConstants.COMPONENTS;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty(value = COMPONENTS)
    private Component component;
}
