package login.repositories;

import login.entities.LoggedUserEntity;
import lombok.AllArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserRepository {
    private Connection conn;

    public List<String> getUsersNames() throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("select * from user");
        ResultSet rs = statement.getResultSet();
        List<String> names = new ArrayList<>();
        while (rs.next()) {
            names.add(rs.getString(4));
        }

        return names;
    }

    public LoggedUserEntity getLoggedUser(String email, String password) throws SQLException {
        String query = "select u.id_user, e.id_employee, e.admin_status from user u " +
                "left join employee e on (e.user_id = u.id_user) " +
                " where u.email = ? and u.password = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        LoggedUserEntity loggedUserEntity = null;
        while (rs.next()) {
            loggedUserEntity = new LoggedUserEntity();
            loggedUserEntity.setUserId(rs.getInt(1));
            loggedUserEntity.setEmployeeId(rs.getInt(2) != 0 ? rs.getInt(2) : null);
            loggedUserEntity.setAdminStatus(rs.getBoolean(3));
        }

        return loggedUserEntity;
    }
}
