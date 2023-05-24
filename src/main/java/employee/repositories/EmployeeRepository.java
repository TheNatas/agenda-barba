package employee.repositories;

import employee.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository {
    Connection conn;

    public Employee getEmployeeFromUserId(Integer userId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from employee e where e.id_employee = ?");
        ps.setInt(1, userId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        Employee employee = new Employee();
        while (rs.next()) {
            employee.setIdEmployee(rs.getInt(1));
            employee.setUserId(rs.getInt(2));
            employee.setAdminStatus(rs.getBoolean(3));
            employee.setBarberShopId(rs.getInt(4));
        }

        return employee;
    }
}
