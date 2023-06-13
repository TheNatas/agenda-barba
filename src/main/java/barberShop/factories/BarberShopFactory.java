package barberShop.factories;

import barberShop.repositories.BarberShopRepository;
import barberShop.services.GetBarberShopInfoService;
import lombok.Builder;
import workInterval.factories.WorkIntervalFactory;

import java.sql.Connection;

@Builder
public class BarberShopFactory {
    Connection conn;

    public GetBarberShopInfoService getBarberShopInfoService() {
        return new GetBarberShopInfoService(this.getBarberShopRepository(), WorkIntervalFactory.builder().conn(conn).build().getWorkIntervalsByBarberShopService());
    }

    private BarberShopRepository getBarberShopRepository() {
        return new BarberShopRepository(conn);
    }
}
