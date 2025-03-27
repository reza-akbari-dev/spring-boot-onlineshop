package shop.dataaccess.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.order.Invoice;
import shop.dataaccess.entity.order.InvoiceItem;
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
