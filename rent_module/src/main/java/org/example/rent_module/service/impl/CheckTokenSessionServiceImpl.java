package org.example.rent_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.UserPersonalData;
import org.example.rent_module.repository.UserCriteriaDaoRepository;
import org.example.rent_module.service.CheckTokenSessionService;
import org.springframework.stereotype.Service;

import static org.example.rent_module.constants.RentApartmentConstants.NO_SUCH_USER_WITH_GIVEN_TOKEN_MESSAGE;

@Service
@RequiredArgsConstructor
public class CheckTokenSessionServiceImpl implements CheckTokenSessionService {

    private final UserCriteriaDaoRepository userCriteriaDaoRepository;

    @Override
    public UserPersonalData checkToken(String token) {
        UserPersonalData user = userCriteriaDaoRepository.findByToken(token);
        if (user == null) {
            throw new RuntimeException(NO_SUCH_USER_WITH_GIVEN_TOKEN_MESSAGE);
        }
        return user;
    }
}
