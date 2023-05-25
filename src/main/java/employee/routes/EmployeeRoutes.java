package employee.routes;

import employee.controllers.CreateEmployeeController;
import employee.controllers.UpdateEmployeeController;
import employee.dtos.IncomingEmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeRoutes {
    @PostMapping("/employee")
    public ResponseEntity<Integer> createEmployee(@RequestBody IncomingEmployeeDto incomingEmployeeDto) {
        return CreateEmployeeController.execute(incomingEmployeeDto);
    }

    @PutMapping("/employee")
    public ResponseEntity<Integer> updateEmployee(@RequestBody IncomingEmployeeDto incomingEmployeeDto) {
        return UpdateEmployeeController.execute(incomingEmployeeDto);
    }
}
