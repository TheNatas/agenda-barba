package service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.factories.ServiceFactory;
import service.models.Service;
import service.services.CreateServiceService;
import service.services.UpdateServiceService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class UpdateServiceController {
    public static ResponseEntity<Integer> execute(Service incomingService) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            UpdateServiceService service = ServiceFactory.builder().conn(conn).build().getUpdateServiceService();
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
