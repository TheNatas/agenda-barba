package barberShop.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class BarberShop {
    private Integer idBarberShop;
    private String shopName;
    private Integer addressId;
}
