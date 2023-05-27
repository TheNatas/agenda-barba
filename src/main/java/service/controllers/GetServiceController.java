package service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.factories.ServiceFactory;
import service.models.Service;
import service.services.GetServiceService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class GetServiceController {
    public static ResponseEntity<Service> execute(Integer id) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            GetServiceService service = ServiceFactory.builder().conn(conn).build().getServiceService();
            Service response = service.execute(id);

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
