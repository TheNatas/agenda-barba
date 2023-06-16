package employee.controllers;

import employee.dtos.EmployeeEntity;
import employee.dtos.IncomingEmployeeDto;
import employee.factories.EmployeeFactory;
import employee.services.CreateEmployeeService;
import employee.services.GetEmployeesFromBarberShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

public class GetEmployeesFromBarberShopController {
    public static ResponseEntity<List<EmployeeEntity>> execute(Integer barberShopId) {
        Connector connector = new Connector();
        try(Connection conn = connector.getConnection();){
            GetEmployeesFromBarberShopService service = EmployeeFactory.builder().conn(conn).build().getEmployeesFromBarberShopService();
            List<EmployeeEntity> response = service.execute(barberShopId);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(response)
                    .toUri();

            if (response.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
            }

            return ResponseEntity.created(uri)
                    .body(response);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}
