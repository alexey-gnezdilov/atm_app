package org.example.rent_module.annotation;

/**
 * Это аннотация нужна, чтобы маппер смог подхватить
 * нужный конструктор.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.CLASS)
public @interface Default {
}
