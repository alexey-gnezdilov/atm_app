package org.example.rent_module.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequestDto {

    private Long apartmentId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String promocode;
    private boolean byCash;

}
