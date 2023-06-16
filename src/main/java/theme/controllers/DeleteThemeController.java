package theme.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import theme.factories.ThemeFactory;
import theme.services.DeleteThemeService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class DeleteThemeController {
    public static ResponseEntity<Integer> execute(Integer id) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            DeleteThemeService service = ThemeFactory.builder().conn(conn).build().getDeleteThemeService();
            int response = service.execute(id);

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
