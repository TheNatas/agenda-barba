package barberShop.services;

import barberShop.entities.BarberShopEntity;
import barberShop.repositories.BarberShopRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class GetBarberShopInfoService {
    private BarberShopRepository barberShopRepository;

    public BarberShopEntity execute(Integer barberShopId) throws SQLException {
        return this.barberShopRepository.getBarberShopInfo(barberShopId);
    }
}
