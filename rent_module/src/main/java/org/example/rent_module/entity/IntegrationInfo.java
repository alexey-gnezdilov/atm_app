package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

import java.time.LocalDateTime;

import static org.example.rent_module.constants.RentApartmentConstants.INTEGRATION_INFO;

@Entity
@Table(name = INTEGRATION_INFO)
@NoArgsConstructor
@Getter
@Setter
public class IntegrationInfo {

    @Id
    private String id;
    private String path;
    private String key;
    private String description;

}
