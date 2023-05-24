package login.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class LoggedUserDto {
    private Integer userId;
    private Boolean isEmployee;
    private Boolean isAdmin;
}
