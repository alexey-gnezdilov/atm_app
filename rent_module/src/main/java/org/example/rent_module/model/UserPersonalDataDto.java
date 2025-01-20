package org.example.rent_module.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserPersonalDataDto {

    private String login;
    private String email;
    private LocalDateTime registrationDate;

}
