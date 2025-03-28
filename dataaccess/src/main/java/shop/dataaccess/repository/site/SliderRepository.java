package shop.dataaccess.repository.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.product.Color;
import shop.dataaccess.entity.site.Slider;

import java.util.List;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Long> {
    List<Slider> findAllByEnableIsTrueOrderByOrderNumberAsc();

}
