package com.example.auth_module.service.impl;

import com.example.auth_module.entity.UserPersonalData;
import com.example.auth_module.exception.UserExistsException;
import com.example.auth_module.model.UserAuthorizationRequestDto;
import com.example.auth_module.model.UserRegistrationRequestDto;
import com.example.auth_module.model.UserRegistrationResponseDto;
import com.example.auth_module.repository.UserRepository;
import com.example.auth_module.service.AuthService;
import com.example.auth_module.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.auth_module.constant.Constants.*;
import static com.example.auth_module.util.Base64EncodeDecode.decoder;
import static com.example.auth_module.util.Base64EncodeDecode.encoder;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public UserRegistrationResponseDto userRegistration(UserRegistrationRequestDto user) {
        if (userRepository.existsUserPersonalDataByLogin(user.getLogin())) {
            throw new UserExistsException(NOT_UNIQUE_LOGIN, CODE_602);
        }
        if (userRepository.existsUserPersonalDataByEmail(user.getEmail())) {
            throw new UserExistsException(NOT_UNIQUE_EMAIL, CODE_603);
        }

        return prepareResponseDto(userRepository.save(prepareUserForDb(user)));
    }

    private UserRegistrationResponseDto prepareResponseDto(UserPersonalData user) {
        return new UserRegistrationResponseDto(
                USER_REGISTRATION_SUCCESS,
                user.getLogin(),
                user.getRegistrationDate()
        );
    }

    @Override
    public String userAuthorization(UserAuthorizationRequestDto user) {
        UserPersonalData userPersonalData = userRepository.findByLogin(user.getLogin())
                .orElseThrow(() -> new UserExistsException(INCORRECT_USER, CODE_605));
        if (!decoder(userPersonalData.getPassword()).equals(user.getPassword())){
            throw new UserExistsException(INCORRECT_PASSWORD, CODE_604);
        }
        userPersonalData.setToken(TokenUtils.generateToken());
        userRepository.save(userPersonalData);
        return USER_AUTHORIZATION_SUCCESS;
    }

    private UserPersonalData prepareUserForDb(UserRegistrationRequestDto user) {
        return new UserPersonalData(user.getLogin(), encoder(user.getPassword()), user.getEmail());
    }
}
