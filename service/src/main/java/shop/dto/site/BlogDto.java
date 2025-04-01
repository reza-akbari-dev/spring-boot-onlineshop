package shop.dto.site;

import jakarta.persistence.*;
import lombok.*;
import shop.dataaccess.entity.file.File;
import shop.dataaccess.enums.BlogStatus;
import shop.dto.file.FileDto;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Long id;
    private String title;
    private String subtitle;
    private LocalDateTime publishDate;
    private Long visitCount;
    private FileDto image;
}
