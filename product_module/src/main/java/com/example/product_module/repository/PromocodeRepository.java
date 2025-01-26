package com.example.product_module.repository;

import com.example.product_module.entity.Promocode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocodeRepository extends JpaRepository<Promocode,Long> {
}
