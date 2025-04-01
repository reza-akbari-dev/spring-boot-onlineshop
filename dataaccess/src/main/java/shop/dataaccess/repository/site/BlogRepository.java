package shop.dataaccess.repository.site;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.site.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("""
                FROM Blog WHERE status = shop.dataaccess.enums.BlogStatus.Published
                AND publishDate <= CURRENT_DATE
                ORDER BY publishDate DESC 
            """)
    List<Blog> findAllByPublished(Pageable pageable);

}
