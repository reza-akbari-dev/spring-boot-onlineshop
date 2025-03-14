package shop.dto.user;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitedUserDto {
    private Long id;

    private String username;
    private String firstname;
    private String lastname;

    private String token;

    public String fullName() {
        return firstname + " " + lastname;
    }
    public String getUsername() {
        return username;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
