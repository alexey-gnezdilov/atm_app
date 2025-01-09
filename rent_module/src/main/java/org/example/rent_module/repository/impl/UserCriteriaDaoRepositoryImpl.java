package org.example.rent_module.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.UserPersonalData;
import org.example.rent_module.repository.UserCriteriaDaoRepository;
import org.springframework.stereotype.Repository;

import static org.example.rent_module.constants.RentApartmentConstants.TOKEN_FIELD;

@Repository
@RequiredArgsConstructor
public class UserCriteriaDaoRepositoryImpl implements UserCriteriaDaoRepository {

    private final EntityManager entityManager;

    @Override
    public UserPersonalData findByToken(String token) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserPersonalData> query = criteriaBuilder.createQuery(UserPersonalData.class);
        Root<UserPersonalData> root = query.from(UserPersonalData.class);
        query.select(root).where(criteriaBuilder.equal(root.get(TOKEN_FIELD), token));
        return entityManager.createQuery(query).getSingleResult();
    }
}
