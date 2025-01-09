package org.example.rent_module.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "apartment_attachment")
@Getter
@Setter
@NoArgsConstructor
public class ApartmentAttachment {

    @Id
    @SequenceGenerator(name = "apartment_attachmentSequence", sequenceName = "apartment_attachment_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_attachmentSequence")
    @Column(name = "id")
    private Long id;
    private String directory;
    private String name;
    private Long size;
    private String type;

    @OneToOne(mappedBy = "file")
    private ApartmentInfo apartmentInfo;

    @Column(name = "photo")
    private byte[] photo;

    public ApartmentAttachment(String directory, String name, Long size, String type, byte[] photo) {
        this.directory = directory;
        this.name = name;
        this.size = size;
        this.type = type;
        this.photo = photo;
    }
}
