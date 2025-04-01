package shop.dto.site;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {
    private Long id;
    private String keyName;
    private String valueContent;
}
