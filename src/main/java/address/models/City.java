package address.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class City {
    private Integer idCity;
    private String cityName;
    private Integer stateId;
}
