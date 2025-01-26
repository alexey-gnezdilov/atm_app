package com.example.auth_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

import static com.example.auth_module.constant.Constants.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserPersonalData {

    @Id
    @SequenceGenerator(name = USER_PERSONAL_DATA_SEQUENCE, sequenceName = USER_PERSONAL_DATA_SEQUENCE_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_PERSONAL_DATA_SEQUENCE)
    @Column(name = ID_COLUMN)
    private Long id;
    private String login;
    private String password;
    private String email;
    private String token;

    @Value(value = EMAIL_VERIFICATION_DEFAULT)
    private boolean emailVerification;

    private LocalDateTime registrationDate;
    private LocalDateTime birthDate;
    private int bookingAmount;
    private boolean foreignCitizen;
    private String cityFrom;

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
