package theme.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import theme.factories.ThemeFactory;
import theme.models.Theme;
import theme.services.GetThemesFromBarberShopService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class GetThemesFromBarberShopController {
    public static ResponseEntity<List<Theme>> execute(Integer barberShopId) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            GetThemesFromBarberShopService service = ThemeFactory.builder().conn(conn).build().getThemesFromBarberShopService();
            List<Theme> response = service.execute(barberShopId);

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
