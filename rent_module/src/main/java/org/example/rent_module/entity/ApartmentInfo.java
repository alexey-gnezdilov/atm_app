package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

import static org.example.rent_module.constants.RentApartmentConstants.*;

@Entity
@Table(name = APARTMENT_INFO)
@NoArgsConstructor
@Getter
@Setter
public class ApartmentInfo {

    @Id
    @SequenceGenerator(name = APARTMENT_INFO_SEQUENCE, sequenceName = APARTMENT_INFO_SEQUENCE_NAME, allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = APARTMENT_INFO_SEQUENCE)
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = ROOMS_COUNT_COLUMN)
    private String roomsCount;

    private String price;
    private String availability;

    @OneToOne(mappedBy = APARTMENT_INFO_MAPPING)
    private AddressInfo addressInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = FILE_ID)
    private ApartmentAttachment file;

    @Default
    public ApartmentInfo(String roomsCount, String price) {
        this.roomsCount = roomsCount;
        this.price = price;
        this.availability = DEFAULT_AVAILABILITY;
    }
}
