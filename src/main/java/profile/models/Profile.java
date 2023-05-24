package profile.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Profile {
    private Integer idProfile;
    private String name;
    private String document;
}
