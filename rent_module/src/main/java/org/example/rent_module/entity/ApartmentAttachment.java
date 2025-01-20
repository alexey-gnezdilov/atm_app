package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import static org.example.rent_module.constants.RentApartmentConstants.*;

@Entity
@Table(name = APARTMENT_ATTACHMENT)
@Getter
@Setter
@NoArgsConstructor
public class ApartmentAttachment {

    @Id
    @SequenceGenerator(name = APARTMENT_ATTACHMENT_SEQUENCE, sequenceName = APARTMENT_ATTACHMENT_SEQUENCE_NAME, allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = APARTMENT_ATTACHMENT_SEQUENCE)
    @Column(name = ID_COLUMN)
    private Long id;

    private String directory;
    private String name;
    private Long size;
    private String type;

    @OneToOne(mappedBy = FILE_COLUMN)
    private ApartmentInfo apartmentInfo;

    @Column(name = PHOTO_COLUMN)
    private byte[] photo;

    public ApartmentAttachment(String directory, String name, Long size, String type, byte[] photo) {
        this.directory = directory;
        this.name = name;
        this.size = size;
        this.type = type;
        this.photo = photo;
    }
}
