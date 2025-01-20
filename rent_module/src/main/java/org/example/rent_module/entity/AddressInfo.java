package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

import java.time.LocalDateTime;

import static org.example.rent_module.constants.RentApartmentConstants.*;

@Entity
@Table(name = ADDRESS_INFO)
@NoArgsConstructor
@Getter
@Setter
public class AddressInfo {

    @Id
    @SequenceGenerator(name = ADDRESS_INFO_SEQUENCE, sequenceName = ADDRESS_INFO_SEQUENCE_NAME, allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ADDRESS_INFO_SEQUENCE)
    @Column(name = ID_COLUMN)
    private Long id;

    private String city;
    private String street;

    @Column(name = HOUSE_NUMBER_COLUMN)
    private String houseNumber;

    @Column(name = REGISTRATION_DATE_COLUMN)
    private LocalDateTime registrationDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = APARTMENT_ID)
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
