package shop.dataaccess.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.order.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
