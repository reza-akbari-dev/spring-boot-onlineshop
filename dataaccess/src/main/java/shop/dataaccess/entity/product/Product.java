package shop.dataaccess.entity.product;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private Boolean enabled= true;
    private Boolean exist= true;
    private Long price;
    private Long visitCount;
    private LocalDateTime addTime;

    @ManyToOne
    @JoinColumn (nullable = false)
    private File image;

    @ManyToMany
    @JoinTable (name ="product_size",
    joinColumns = @JoinColumn( name ="product_id"),
    inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Size> sizes;

    @ManyToMany
    @JoinTable(name = "product_color",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color>colors;

}
