package theme.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import theme.factories.ThemeFactory;
import theme.models.Theme;
import theme.services.UpdateThemeService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class UpdateThemeController {
    public static ResponseEntity<Integer> execute(Theme incomingTheme) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            UpdateThemeService service = ThemeFactory.builder().conn(conn).build().getUpdateThemeService();
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
