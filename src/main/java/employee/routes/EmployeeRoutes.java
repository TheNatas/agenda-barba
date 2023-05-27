package employee.routes;

import employee.controllers.CreateEmployeeController;
import employee.controllers.GetEmployeeController;
import employee.controllers.GetEmployeesFromBarberShopController;
import employee.controllers.UpdateEmployeeController;
import employee.dtos.EmployeeEntity;
import employee.dtos.IncomingEmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> getEmployeesFromBarberShop(@RequestParam(value = "id") Integer barberShopId) {
        return GetEmployeesFromBarberShopController.execute(barberShopId);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Integer id) {
        return GetEmployeeController.execute(id);
    }
}
