package user.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class User {
    private Integer idUser;
    private Integer profileId;
    private Boolean active;
    private String email;
    private String password;
}
