package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

import java.time.LocalDateTime;

@Entity
@Table(name = "integration_info")
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
