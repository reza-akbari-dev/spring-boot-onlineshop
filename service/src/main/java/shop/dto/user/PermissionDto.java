package shop.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto {
    private Long id;

    public String getName() {
        return name;
    }
    private String name;
    private String description;
    private PermissionDto parent;

}