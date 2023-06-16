package workInterval.controllers;

import workInterval.dtos.FullWorkIntervalDto;
import workInterval.factories.WorkIntervalFactory;
import workInterval.services.UpdateWorkIntervalsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class UpdateWorkIntervalsController {
    public static ResponseEntity<Integer> execute(FullWorkIntervalDto workIntervalDto) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            UpdateWorkIntervalsService service = WorkIntervalFactory.builder().conn(conn).build().updateWorkIntervalsService();
            int response = service.execute(workIntervalDto);

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