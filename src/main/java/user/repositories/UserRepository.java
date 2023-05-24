package user.repositories;

import login.entities.LoggedUserEntity;
import lombok.AllArgsConstructor;
import user.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserRepository {
    private Connection conn;

    public int createUser(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into user (profile_id, active, email, password) values (?,?,?,?)");
        ps.setInt(1, user.getProfileId());
        ps.setBoolean(2, user.getActive());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        return ps.execute() ? 1 : 0;
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
