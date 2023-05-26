package user.repositories;

import login.entities.LoggedUserEntity;
import lombok.AllArgsConstructor;
import user.models.User;
import java.sql.*;
import java.util.ArrayList;

@AllArgsConstructor
public class UserRepository {
    private Connection conn;

    public User getUser(Integer id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from user u where u.id_user = ?");
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        User user = null;
        while (rs.next()) {
            user = new User();
            user.setIdUser(rs.getInt("id_user"));
            user.setProfileId(rs.getInt("profile_id"));
            user.setActive(rs.getBoolean("active"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }

        return user;
    }

    public int createUser(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into user (profile_id, active, email, password) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, user.getProfileId());
        ps.setBoolean(2, user.getActive());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.execute();

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
    }

    public int updateUser(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update user set profile_id = ?, active = ?, email = ?, password = ? where id_user = ?");
        ps.setInt(1, user.getProfileId());
        ps.setBoolean(2, user.getActive());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setInt(5, user.getIdUser());
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

    public ArrayList<User> getAllUsers() throws SQLException{
        String query = "select id_user, profile_id, active, email from user";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> list = new ArrayList<User>();
        while(rs.next()){
            User user = new User();
            user.setIdUser(rs.getInt("id_user"));
            user.setProfileId(rs.getInt("profile_id"));
            user.setActive(rs.getBoolean("active"));
            user.setEmail(rs.getString("email"));
            list.add(user);
        }

        return list;
    }
}
