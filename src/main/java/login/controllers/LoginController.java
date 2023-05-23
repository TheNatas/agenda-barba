package login.controllers;

import login.factories.LoginFactory;
import login.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class LoginController {
    public static ResponseEntity<List<String>> execute(String name) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            LoginService service = LoginFactory.builder().conn(conn).build().getLoginService();
            List<String> response = service.execute(name);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
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
