package org.example.rent_module.service;

import org.example.rent_module.entity.UserPersonalData;

public interface CheckTokenSessionService {
    UserPersonalData checkToken(String token);
}
