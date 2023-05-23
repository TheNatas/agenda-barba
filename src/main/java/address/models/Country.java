package address.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Country {
    private Integer idCountry;
    private String countryName;
}
