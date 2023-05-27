package employee.services;

import employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class DeleteEmployeeService {
    private EmployeeRepository employeeRepository;

    public int execute(Integer id) throws SQLException {
        return this.employeeRepository.delete(id);
    }
}
