package com.example.product_module.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.product_module.constant.ProductModuleConstants.PROMOCODES_TABLE;

@Entity
@Table(name = PROMOCODES_TABLE)
@NoArgsConstructor
@Getter
@Setter
public class Promocode {

    @Id
    private Long id;
    private String promocode;
    private boolean used;
    private int userId;

}
