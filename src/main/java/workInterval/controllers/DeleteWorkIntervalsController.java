package workInterval.controllers;

import workInterval.dtos.MinWorkIntervalDto;
import workInterval.factories.WorkIntervalFactory;
import workInterval.services.DeleteWorkIntervalsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class DeleteWorkIntervalsController {
    public static ResponseEntity<Integer> execute(MinWorkIntervalDto workIntervalDto) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            DeleteWorkIntervalsService service = WorkIntervalFactory.builder().conn(conn).build().deleteWorkIntervalsService();
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