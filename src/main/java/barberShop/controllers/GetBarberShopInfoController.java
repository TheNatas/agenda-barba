package barberShop.controllers;

import barberShop.entities.BarberShopEntity;
import barberShop.factories.BarberShopFactory;
import barberShop.services.GetBarberShopInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class GetBarberShopInfoController {
    public static ResponseEntity<BarberShopEntity> execute(Integer barberShopId) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            GetBarberShopInfoService service = BarberShopFactory.builder().conn(conn).build().getBarberShopInfoService();
            BarberShopEntity response = service.execute(barberShopId);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(response)
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(response);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}
