package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rent_module.annotation.Default;

@Entity
@Table(name = "apartment_info")
@NoArgsConstructor
@Getter
@Setter
public class ApartmentInfo {

    @Id
    @SequenceGenerator(name = "apartment_infoSequence", sequenceName = "apartment_info_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_infoSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "rooms_count")
    private String roomsCount;
    private String price;
    private String availability;

    @OneToOne(mappedBy = "apartmentInfo")
    private AddressInfo addressInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private ApartmentAttachment file;

    @Default
    public ApartmentInfo(String roomsCount, String price) {
        this.roomsCount = roomsCount;
        this.price = price;
        this.availability = "false";
    }
}
