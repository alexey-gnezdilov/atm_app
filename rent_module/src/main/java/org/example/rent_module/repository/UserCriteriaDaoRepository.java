package org.example.rent_module.repository;

import org.example.rent_module.entity.UserPersonalData;

public interface UserCriteriaDaoRepository {

    UserPersonalData findByToken(String token);
}
