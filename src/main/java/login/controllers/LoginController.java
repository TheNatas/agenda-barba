package login.controllers;

import login.factories.LoginFactory;
import login.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class LoginController {
    public static ResponseEntity<String> execute(String name) {
        try {
            Connection conn = Connector.builder().build().getConnection();
            LoginService service = LoginFactory.builder().conn(conn).build().getLoginService();
            String response = service.execute(name);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(response)
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
