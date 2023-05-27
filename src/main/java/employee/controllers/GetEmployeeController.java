package employee.controllers;

import employee.dtos.EmployeeEntity;
import employee.dtos.IncomingEmployeeDto;
import employee.factories.EmployeeFactory;
import employee.services.CreateEmployeeService;
import employee.services.GetEmployeeService;
import employee.services.GetEmployeesFromBarberShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class GetEmployeeController {
    public static ResponseEntity<EmployeeEntity> execute(Integer id) {
        try {
            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            GetEmployeeService service = EmployeeFactory.builder().conn(conn).build().getEmployeeService();
            EmployeeEntity response = service.execute(id);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(response)
                    .toUri();

            if (response == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }

            return ResponseEntity.created(uri)
                    .body(response);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}
