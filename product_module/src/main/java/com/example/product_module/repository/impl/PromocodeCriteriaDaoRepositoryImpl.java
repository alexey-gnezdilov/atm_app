package com.example.product_module.repository.impl;

import com.example.product_module.entity.Promocode;
import com.example.product_module.repository.PromocodeCriteriaDaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.product_module.constant.ProductModuleConstants.PROMOCODE_FIELD;

@Repository
@RequiredArgsConstructor
public class PromocodeCriteriaDaoRepositoryImpl implements PromocodeCriteriaDaoRepository {

    private final EntityManager entityManager;

    @Override
    public Promocode findByPromocode(String promocode) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Promocode> query = criteriaBuilder.createQuery(Promocode.class);
        Root<Promocode> root = query.from(Promocode.class);
        query.select(root).where(criteriaBuilder.equal(root.get(PROMOCODE_FIELD), promocode));
        return entityManager.createQuery(query).getSingleResult();
    }
}
