package shop.dataaccess.entity.site;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;
import shop.dataaccess.enums.BlogStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String subtitle;

    private LocalDateTime publishDate;
    private BlogStatus status;
    private Long visitCount;

    @ManyToOne
    @JoinColumn(nullable = false)
    private File image;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
}
