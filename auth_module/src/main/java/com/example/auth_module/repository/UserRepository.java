package com.example.auth_module.repository;

import com.example.auth_module.entity.UserPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import static com.example.auth_module.constant.Constants.FIND_USER_PERSONAL_DATA_BY_LOGIN;

public interface UserRepository extends JpaRepository<UserPersonalData, Long> {

    boolean existsUserPersonalDataByLogin(String login);

    boolean existsUserPersonalDataByEmail(String email);

    @Query(FIND_USER_PERSONAL_DATA_BY_LOGIN)
    Optional<UserPersonalData> findByLogin(String login);

    Optional<UserPersonalData> findByEmail(String email);

    List<UserPersonalData> findUserPersonalDataByTokenIsNotNull();

}
