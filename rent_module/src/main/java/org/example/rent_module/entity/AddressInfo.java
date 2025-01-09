package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address_info")
@NoArgsConstructor
@Getter
@Setter
public class AddressInfo {

    @Id
    @SequenceGenerator(name = "address_infoSequence", sequenceName = "address_info_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_infoSequence")
    @Column(name = "id")
    private Long id;
    private String city;
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private ApartmentInfo apartmentInfo;

    @Default
    public AddressInfo(String city, String street, String houseNumber, ApartmentInfo apartmentInfo) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.registrationDate = LocalDateTime.now();
        this.apartmentInfo = apartmentInfo;
    }
}
