package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

import java.time.LocalDateTime;

import static org.example.rent_module.constants.RentApartmentConstants.*;

@Entity
@Table(name = BOOKING_APARTMENT)
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingApartment {

    @Id
    @SequenceGenerator(name = BOOKING_APARTMENT_SEQUENCE, sequenceName = BOOKING_APARTMENT_SEQUENCE_NAME, allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BOOKING_APARTMENT_SEQUENCE)
    @Column(name = ID_COLUMN)
    private Long id;
    private Long userId;
    private Long apartmentId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private String totalPrice;

    public BookingApartment(Long id, Long userId, Long apartmentId, LocalDateTime startDate, LocalDateTime endDate, Long productId, String totalPrice) {
        this.id = id;
        this.userId = userId;
        this.apartmentId = apartmentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.totalPrice = totalPrice;
    }

    @Default
    public BookingApartment(Long userId, Long apartmentId, LocalDateTime startDate, LocalDateTime endDate, Long productId, String totalPrice) {
        this.userId = userId;
        this.apartmentId = apartmentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.totalPrice = totalPrice;
    }
}
