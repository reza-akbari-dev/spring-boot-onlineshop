package shop.app.model;

import lombok.*;
import shop.app.model.enums.APIStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {
    private String message = "";
    private APIStatus status;
    private T data;
}
