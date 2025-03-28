package shop.dto.product;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SizeDto {
    private Long id;
    private String title;
    private String description;
}
