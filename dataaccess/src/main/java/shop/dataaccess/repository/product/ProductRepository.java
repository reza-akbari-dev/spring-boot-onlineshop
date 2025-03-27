package shop.dataaccess.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.product.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
