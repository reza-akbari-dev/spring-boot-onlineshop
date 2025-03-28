package shop.dto.site;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;
import shop.dto.file.FileDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SliderDto {
    private Long id;
    private String title;
    private String link;
    private Integer orderNumber;
    private FileDto image;
}
