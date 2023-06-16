package user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import user.dtos.IncomingUserDto;
import user.factories.UserFactory;
import user.models.User;
import user.services.GetAllUserService;
import user.services.UpdateUserService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.ArrayList;

public class GetAllUserController {

    public static ResponseEntity<ArrayList<User>> execute() {
        //try {
            Connector connector = new Connector();
            try(Connection conn = connector.getConnection();){
                GetAllUserService service = UserFactory.builder().conn(conn).build().getAllUserService();
                ArrayList<User> response = service.execute();

                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .buildAndExpand(response)
                        .toUri();

                return ResponseEntity.created(uri)
                        .body(response);
          //  }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}
