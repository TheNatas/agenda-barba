package barberShop.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class BarberShopEntity {
    private Integer idBarberShop;
    private String shopName;
    private String addressDesc;
    private Integer addressNumber;
    private String addressComplement;
    private String addressCode;
    private String cityName;
    private String stateName;
    private String countryName;
}
