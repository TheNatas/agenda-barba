package workInterval.controllers;

import workInterval.dtos.NewWorkIntervalDto;
import workInterval.factories.WorkIntervalFactory;
import workInterval.services.InsertWorkIntervalsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class InsertWorkIntervalsController {
    public static ResponseEntity<Integer> execute(NewWorkIntervalDto workIntervalEntity) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            InsertWorkIntervalsService service = WorkIntervalFactory.builder().conn(conn).build().insertWorkIntervalsService();
            int response = service.execute(workIntervalEntity);

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