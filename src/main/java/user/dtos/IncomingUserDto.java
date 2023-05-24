package user.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class IncomingUserDto {
    private Integer userId;
    private Integer profileId;
    private String name;
    private String document;
    private String email;
    private String password;
}
