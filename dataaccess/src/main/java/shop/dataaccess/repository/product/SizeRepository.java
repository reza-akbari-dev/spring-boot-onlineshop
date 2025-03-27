package shop.dataaccess.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.product.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
}
