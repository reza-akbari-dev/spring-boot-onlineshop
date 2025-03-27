package shop.dataaccess.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.product.Color;
import shop.dataaccess.entity.product.ProductCategory;
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
