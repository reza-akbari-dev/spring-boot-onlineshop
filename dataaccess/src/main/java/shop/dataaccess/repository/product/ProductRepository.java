package shop.dataaccess.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.product.Product;
import shop.dataaccess.entity.product.ProductCategory;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
    FROM Product WHERE enable=true
    AND exist=true
    ORDER BY visitCount desc 
    LIMIT 6
""")
    List<Product> find6PopularProducts();

    @Query("""
FROM Product WHERE enable=true
AND exist=true
ORDER BY addTime asc 
LIMIT 6
""")
    List<Product> find6NewestProducts();

    @Query("""
FROM Product WHERE enable=true
AND exist=true
ORDER BY price asc 
LIMIT 6
""")
    List<Product> ind6CheapestProducts();

    @Query("""
            FROM Product WHERE enable=true
                AND exist=true
                ORDER BY price desc 
            """)
    List<Product> find6ExpensiveProducts();
}


