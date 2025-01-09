package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserPersonalData {

    @Id
    @SequenceGenerator(name = "user_personal_dataSequence", sequenceName = "user_personal_data_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_personal_dataSequence")
    @Column(name = "id")
    private Long id;
    private String login;
    private String password;
    private String email;
    private String token;

    @Value(value = "false")
    private boolean emailVerification;

    private LocalDateTime registrationDate;

    public UserPersonalData(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.registrationDate = LocalDateTime.now();
    }
}
