package barberShop.dtos;

import lombok.*;
import workInterval.dtos.WorkIntervalDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BarberShopDto {
    private Integer idBarberShop;
    private String shopName;
    private String addressDesc;
    private Integer addressNumber;
    private String addressComplement;
    private String addressCode;
    private String cityName;
    private String stateName;
    private String countryName;
    private List<WorkIntervalDto> workIntervals;
}
