package employee.services;

import employee.dtos.EmployeeEntity;
import employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetEmployeesFromBarberShopService {
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> execute(Integer barberShopId) throws SQLException {
        return this.employeeRepository.getEmployeesFromBarberShop(barberShopId);
    }
}
