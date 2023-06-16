package theme.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import theme.factories.ThemeFactory;
import theme.models.Theme;
import theme.services.CreateThemeService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class CreateThemeController {
    public static ResponseEntity<Integer> execute(Theme incomingTheme) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            CreateThemeService service = ThemeFactory.builder().conn(conn).build().getCreateThemeService();
            int response = service.execute(incomingTheme);

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
