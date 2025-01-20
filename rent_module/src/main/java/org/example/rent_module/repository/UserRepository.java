package org.example.rent_module.repository;

import org.example.rent_module.entity.UserPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import static org.example.rent_module.constants.RentApartmentConstants.USER_PERSONAL_DATA_QUERY;

public interface UserRepository extends JpaRepository<UserPersonalData, Long> {

    @Query(USER_PERSONAL_DATA_QUERY)
    Optional<UserPersonalData> findByToken(String token);

}
