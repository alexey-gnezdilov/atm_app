package org.example.rent_module.repository;

import org.example.rent_module.entity.UserPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPersonalData, Long> {

//    @Query("select u from UserPersonalData u where u.token = :token")
//    Optional<UserPersonalData> findByToken(String token);

}
