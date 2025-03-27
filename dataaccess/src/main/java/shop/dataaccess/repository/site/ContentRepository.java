package shop.dataaccess.repository.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.product.Color;
import shop.dataaccess.entity.site.Content;
@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
}
