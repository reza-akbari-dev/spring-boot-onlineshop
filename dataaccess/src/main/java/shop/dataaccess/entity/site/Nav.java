package shop.dataaccess.entity.site;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String title;

    @Column (nullable = false, length = 1000)
    private String link;

    private Boolean enable;
    private Integer orderNumber;

}
