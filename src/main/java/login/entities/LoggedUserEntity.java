package login.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class LoggedUserEntity {
    private Integer userId;
    private Integer employeeId;
    private Boolean adminStatus;
}
