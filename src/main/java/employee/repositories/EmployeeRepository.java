package employee.repositories;

import employee.models.Employee;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
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

    public int createEmployee(Employee employee) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into employee (user_id, admin_status, barber_shop_id) values (?,?,?)");
        ps.setInt(1, employee.getUserId());
        ps.setBoolean(2, employee.getAdminStatus());
        ps.setInt(3, employee.getBarberShopId());
        return ps.execute() ? 1 : 0;
    }

    public int updateEmployee(Employee employee) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update employee set admin_status = ? where id_employee = ?");
        ps.setBoolean(1, employee.getAdminStatus());
        ps.setInt(2, employee.getIdEmployee());
        return ps.execute() ? 1 : 0;
    }
}
