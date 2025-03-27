package shop.dataaccess.entity.order;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.product.Color;
import shop.dataaccess.entity.product.Product;
import shop.dataaccess.entity.product.Size;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Invoice invoice;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Color color;

    @ManyToOne
    private Size size;

}
