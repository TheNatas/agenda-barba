package employee.services;

import employee.dtos.IncomingEmployeeDto;
import employee.models.Employee;
import employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import profile.repositories.ProfileRepository;
import user.dtos.IncomingUserDto;
import user.repositories.UserRepository;
import user.services.CreateUserService;

import java.sql.SQLException;

@AllArgsConstructor
public class CreateEmployeeService {
    private EmployeeRepository employeeRepository;
    private CreateUserService createUserService;

    public int execute(IncomingEmployeeDto incomingEmployeeDto) throws SQLException {
        Integer savedUserId = this.createUserService.execute(
                IncomingUserDto.builder()
                        .name(incomingEmployeeDto.getName())
                        .document(incomingEmployeeDto.getDocument())
                        .email(incomingEmployeeDto.getEmail())
                        .password(incomingEmployeeDto.getPassword())
                        .build()
        );

        Employee employee = Employee.builder()
                .userId(savedUserId)
                .adminStatus(incomingEmployeeDto.getAdminStatus())
                .barberShopId(incomingEmployeeDto.getBarberShopId())
                .build();

        return this.employeeRepository.createEmployee(employee);
    }
}
