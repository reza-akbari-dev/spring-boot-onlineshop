package shop.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String username;
    private String password;
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

}
