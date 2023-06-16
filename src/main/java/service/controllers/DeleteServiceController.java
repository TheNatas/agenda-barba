package service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.factories.ServiceFactory;
import service.models.Service;
import service.services.CreateServiceService;
import service.services.DeleteServiceService;
import service.services.UpdateServiceService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class DeleteServiceController {
    public static ResponseEntity<Integer> execute(Integer id) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            DeleteServiceService service = ServiceFactory.builder().conn(conn).build().getDeleteServiceService();
            int response = service.execute(id);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(response)
                    .toUri();

            if (response <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(response);
            }

            return ResponseEntity.ok()
                    .body(response);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}
