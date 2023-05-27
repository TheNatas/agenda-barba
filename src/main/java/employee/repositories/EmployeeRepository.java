package employee.repositories;

import employee.dtos.EmployeeEntity;
import employee.models.Employee;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class EmployeeRepository {
    Connection conn;

    public EmployeeEntity getEmployeeFromEmployeeId(Integer employeeId) throws SQLException {
        String query = "select e.*, p.name from employee e " +
                "inner join user u on (u.id_user = e.user_id) " +
                "inner join profile p on (u.profile_id = p.id_profile) " +
                "where e.id_employee = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, employeeId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        EmployeeEntity employee = null;
        while (rs.next()) {
            employee = new EmployeeEntity();
            employee.setIdEmployee(rs.getInt(1));
            employee.setUserId(rs.getInt(2));
            employee.setAdminStatus(rs.getBoolean(3));
            employee.setBarberShopId(rs.getInt(4));
            employee.setName(rs.getString(5));
        }

        return employee;
    }

    public List<EmployeeEntity> getEmployeesFromBarberShop(Integer barberShopId) throws SQLException {
        String query = "select e.*, p.name from employee e " +
                "inner join user u on (u.id_user = e.user_id) " +
                "inner join profile p on (u.profile_id = p.id_profile) " +
                "where e.barber_shop_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, barberShopId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        List<EmployeeEntity> employees = new ArrayList<>();
        while (rs.next()) {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setIdEmployee(rs.getInt(1));
            employee.setUserId(rs.getInt(2));
            employee.setAdminStatus(rs.getBoolean(3));
            employee.setBarberShopId(rs.getInt(4));
            employee.setName(rs.getString(5));
            employees.add(employee);
        }

        return employees;
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

    public int delete(Integer id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from employee where id_employee = ?");
        ps.setInt(1, id);
        return ps.executeUpdate();
    }
}
