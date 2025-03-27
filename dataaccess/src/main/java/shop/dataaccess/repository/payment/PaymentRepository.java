package shop.dataaccess.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.payment.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
