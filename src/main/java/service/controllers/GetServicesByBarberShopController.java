package service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.factories.ServiceFactory;
import service.models.Service;
import service.services.GetServiceService;
import service.services.GetServicesByBarberShopService;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class GetServicesByBarberShopController {
    public static ResponseEntity<List<Service>> execute(Integer barberShopId) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            GetServicesByBarberShopService service = ServiceFactory.builder().conn(conn).build().getServicesByBarberShopService();
            List<Service> response = service.execute(barberShopId);

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
