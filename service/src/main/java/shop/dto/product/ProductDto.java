package shop.dto.product;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;
import shop.dataaccess.entity.product.Color;
import shop.dataaccess.entity.product.ProductCategory;
import shop.dataaccess.entity.product.Size;
import shop.dto.file.FileDto;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Long price;
    private Long visitCount;
    private LocalDateTime addTime;
    private FileDto image;
    private Set<SizeDto> sizes;
    private Set<ColorDto>colors;
    private ProductCategoryDto category;
}
