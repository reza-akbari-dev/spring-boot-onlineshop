package shop.dataaccess.entity.order;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false)
    private String Number;

    private LocalDateTime createDate;
    private LocalDateTime payedDate;
    private OrderStatus status;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> items;

}
