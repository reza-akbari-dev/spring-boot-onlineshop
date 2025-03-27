package shop.dataaccess.entity.site;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, length = 1000)
    private String link;

    private Boolean enable;
    private Integer orderNumber;

    @ManyToOne
    @JoinColumn (nullable = false)
    private File image;
}
