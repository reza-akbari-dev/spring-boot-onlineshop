package shop.dto.product;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;
import shop.dto.file.FileDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDto {
    private Long id;
    private String title;
    private String description;
    private FileDto image;
}
