package theme.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import theme.factories.ThemeFactory;
import theme.models.Theme;
import theme.services.GetThemeService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class GetThemeController {
    public static ResponseEntity<Theme> execute(Integer id) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            GetThemeService service = ThemeFactory.builder().conn(conn).build().getThemeService();
            Theme response = service.execute(id);

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
