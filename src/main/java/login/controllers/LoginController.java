package login.controllers;

import login.dtos.LoginDto;
import login.entities.LoggedUserEntity;
import login.factories.LoginFactory;
import login.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class LoginController {
    public static ResponseEntity<LoggedUserEntity> execute(LoginDto loginDto) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            LoginService service = LoginFactory.builder().conn(conn).build().getLoginService();
            LoggedUserEntity response = service.execute(loginDto);

            if (response == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

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
