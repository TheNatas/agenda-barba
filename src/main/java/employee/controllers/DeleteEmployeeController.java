package employee.controllers;

import employee.dtos.IncomingEmployeeDto;
import employee.factories.EmployeeFactory;
import employee.services.DeleteEmployeeService;
import employee.services.UpdateEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class DeleteEmployeeController {
    public static ResponseEntity<Integer> execute(Integer id) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            DeleteEmployeeService service = EmployeeFactory.builder().conn(conn).build().getDeleteEmployeeService();
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
