package shop.dataaccess.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.payment.Payment;
import shop.dataaccess.entity.product.Color;
@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}
