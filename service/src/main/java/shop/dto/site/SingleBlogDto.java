package shop.dto.site;

import lombok.*;
import shop.dto.file.FileDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleBlogDto {
    private Long id;
    private String title;
    private String link;
    private Integer orderNumber;
    private FileDto image;
    private String description;
}
