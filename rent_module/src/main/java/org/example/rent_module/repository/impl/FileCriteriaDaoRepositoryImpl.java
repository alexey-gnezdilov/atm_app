package org.example.rent_module.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.ApartmentAttachment;
import org.example.rent_module.repository.FileCriteriaDaoRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileCriteriaDaoRepositoryImpl implements FileCriteriaDaoRepository {

    private final EntityManager entityManager;

    @Override
    public byte[] findById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<byte[]> query = criteriaBuilder.createQuery(byte[].class);
        Root<ApartmentAttachment> root = query.from(ApartmentAttachment.class);
        query.select(root.get("photo")).where(criteriaBuilder.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }
}
