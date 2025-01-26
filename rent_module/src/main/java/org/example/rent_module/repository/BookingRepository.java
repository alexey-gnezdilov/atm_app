package org.example.rent_module.repository;

import org.example.rent_module.entity.BookingApartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingApartment, Long> {
}
