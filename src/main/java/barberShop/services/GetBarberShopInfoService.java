package barberShop.services;

import barberShop.dtos.BarberShopDto;
import barberShop.entities.BarberShopEntity;
import barberShop.repositories.BarberShopRepository;
import lombok.AllArgsConstructor;
import workInterval.dtos.WorkIntervalDto;
import workInterval.repositories.WorkIntervalRepository;
import workInterval.services.GetWorkIntervalsByBarberShopService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class GetBarberShopInfoService {
    private BarberShopRepository barberShopRepository;
    private GetWorkIntervalsByBarberShopService getWorkIntervalsByBarberShopService;

    public BarberShopDto execute(Integer barberShopId) throws SQLException {
        BarberShopEntity barberShopEntity = this.barberShopRepository.getBarberShopInfo(barberShopId);
        List<WorkIntervalDto> workIntervals = this.getWorkIntervalsByBarberShopService.execute(barberShopId);
        return BarberShopDto.builder()
                .idBarberShop(barberShopId)
                .shopName(barberShopEntity.getShopName())
                .addressDesc(barberShopEntity.getAddressDesc())
                .addressNumber(barberShopEntity.getAddressNumber())
                .addressComplement(barberShopEntity.getAddressComplement())
                .addressCode(barberShopEntity.getAddressCode())
                .cityName(barberShopEntity.getCityName())
                .stateName(barberShopEntity.getStateName())
                .countryName(barberShopEntity.getCountryName())
                .workIntervals(workIntervals)
                .build();
    }
}
