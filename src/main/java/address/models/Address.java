package address.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Address {
    private Integer idAddress;
    private String addressDesc;
    private Integer addressNumber;
    private String addressComplement;
    private String addressCode;
    private Integer cityId;
}
