package employee.controllers;

import employee.dtos.IncomingEmployeeDto;
import employee.factories.EmployeeFactory;
import employee.services.CreateEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class CreateEmployeeController {
    public static ResponseEntity<Integer> execute(IncomingEmployeeDto incomingEmployeeDto) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            CreateEmployeeService service = EmployeeFactory.builder().conn(conn).build().getCreateEmployeeService();
            int response = service.execute(incomingEmployeeDto);

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
