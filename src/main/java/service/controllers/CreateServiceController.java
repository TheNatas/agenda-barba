package service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.factories.ServiceFactory;
import service.models.Service;
import service.services.CreateServiceService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class CreateServiceController {
    public static ResponseEntity<Integer> execute(Service incomingService) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            CreateServiceService service = ServiceFactory.builder().conn(conn).build().getCreateServiceService();
            int response = service.execute(incomingService);

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
