package workInterval.controllers;

import workInterval.dtos.NewWorkIntervalDto;
import workInterval.dtos.WorkIntervalDto;
import workInterval.factories.WorkIntervalFactory;
import workInterval.services.GetWorkIntervalsByBarberShopService;
import workInterval.services.InsertWorkIntervalsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class GetWorkIntervalsByBarberShopController {
    public static ResponseEntity<List<WorkIntervalDto>> execute(Integer barberShopId) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            GetWorkIntervalsByBarberShopService service = WorkIntervalFactory.builder().conn(conn).build().getWorkIntervalsByBarberShopService();
            List<WorkIntervalDto> response = service.execute(barberShopId);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(response)
                    .toUri();

            return ResponseEntity.created(uri).body(response);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}