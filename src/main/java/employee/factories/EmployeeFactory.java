package employee.factories;

import employee.repositories.EmployeeRepository;
import employee.services.*;
import lombok.Builder;
import user.factories.UserFactory;

import java.sql.Connection;

@Builder
public class EmployeeFactory {
    Connection conn;

    public CreateEmployeeService getCreateEmployeeService() {
        return new CreateEmployeeService(this.getEmployeeRepository(), UserFactory.builder().conn(conn).build().getCreateUserService());
    }

    public UpdateEmployeeService getUpdateEmployeeService() {
        return new UpdateEmployeeService(this.getEmployeeRepository(), UserFactory.builder().conn(conn).build().getUpdateUserService());
    }

    public DeleteEmployeeService getDeleteEmployeeService() {
        return new DeleteEmployeeService(this.getEmployeeRepository());
    }

    public GetEmployeesFromBarberShopService getEmployeesFromBarberShopService() {
        return new GetEmployeesFromBarberShopService(this.getEmployeeRepository());
    }

    public GetEmployeeService getEmployeeService() {
        return new GetEmployeeService(this.getEmployeeRepository());
    }

    private EmployeeRepository getEmployeeRepository() {
        return new EmployeeRepository(conn);
    }
}
