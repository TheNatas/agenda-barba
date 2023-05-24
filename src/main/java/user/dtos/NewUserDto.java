package user.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class NewUserDto {
    private String name;
    private String document;
    private String email;
    private String password;
}
