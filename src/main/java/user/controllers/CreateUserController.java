package user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import user.dtos.IncomingUserDto;
import user.factories.UserFactory;
import user.services.CreateUserService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class CreateUserController {
    public static ResponseEntity<Integer> execute(IncomingUserDto incomingUserDto) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            CreateUserService service = UserFactory.builder().conn(conn).build().getCreateUserService();
            int response = service.execute(incomingUserDto);

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
