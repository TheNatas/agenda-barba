package employee.services;

import employee.dtos.EmployeeEntity;
import employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class GetEmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeEntity execute(Integer id) throws SQLException {
        return this.employeeRepository.getEmployeeFromEmployeeId(id);
    }
}
