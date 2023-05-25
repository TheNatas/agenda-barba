package employee.services;

import employee.dtos.IncomingEmployeeDto;
import employee.models.Employee;
import employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import user.dtos.IncomingUserDto;
import user.services.UpdateUserService;

import java.sql.SQLException;

@AllArgsConstructor
public class UpdateEmployeeService {
    private EmployeeRepository employeeRepository;
    private UpdateUserService updateUserService;

    public int execute(IncomingEmployeeDto incomingEmployeeDto) throws SQLException {
        this.updateUserService.execute(
                IncomingUserDto.builder()
                        .userId(incomingEmployeeDto.getUserId())
                        .profileId(incomingEmployeeDto.getProfileId())
                        .name(incomingEmployeeDto.getName())
                        .document(incomingEmployeeDto.getDocument())
                        .email(incomingEmployeeDto.getEmail())
                        .password(incomingEmployeeDto.getPassword())
                        .build()
        );

        return this.employeeRepository.updateEmployee(
                Employee.builder()
                        .idEmployee(incomingEmployeeDto.getIdEmployee())
                        .adminStatus(incomingEmployeeDto.getAdminStatus())
                        .build()
        );
    }
}
