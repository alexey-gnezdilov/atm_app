package com.example.product_module.repository;

import com.example.product_module.entity.Promocode;

public interface PromocodeCriteriaDaoRepository {

    Promocode findByPromocode(String promocode);
}
