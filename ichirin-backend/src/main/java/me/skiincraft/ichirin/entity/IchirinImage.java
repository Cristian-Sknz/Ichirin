package me.skiincraft.ichirin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
@SequenceGenerator(name = "images", sequenceName = "seq_images")
public class IchirinImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "images")
    private Long id;
    private String name;
    private String contentType;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(nullable = false)
    private byte[] data;

    private Long size;

    public IchirinImage(String name) {
        this.name = name;
        this.contentType = "image/png";
    }

    public IchirinImage(String name, MultipartFile file) throws IOException {
        this.name = name;
        this.data = file.getBytes();
        this.size = file.getSize();
        this.contentType = file.getContentType();
    }
}
