package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

import static org.example.rent_module.constants.RentApartmentConstants.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserPersonalData {

    @Id
    @SequenceGenerator(name = USER_PERSONAL_SEQUENCE, sequenceName = USER_PERSONAL_SEQUENCE_NAME, allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_PERSONAL_SEQUENCE)
    @Column(name = ID_COLUMN)
    private Long id;

    private String login;
    private String password;
    private String email;
    private String token;

    @Value(value = DEFAULT_EMAIL_VERIFICATION)
    private boolean emailVerification;

    private LocalDateTime registrationDate;
    private LocalDateTime birthDate;
    private int bookingAmount;
    private boolean foreignCitizen;
    private String cityFrom;

    @Default
    public UserPersonalData(String login, String password, String email, LocalDateTime birthDate, boolean foreignCitizen, String cityFrom) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.registrationDate = LocalDateTime.now();
        this.birthDate = birthDate;
        this.bookingAmount = 0;
        this.foreignCitizen = foreignCitizen;
        this.cityFrom = cityFrom;
    }
}
