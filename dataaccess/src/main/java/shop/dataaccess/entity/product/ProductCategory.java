package shop.dataaccess.entity.product;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn (nullable = false)
    private File image;
}
