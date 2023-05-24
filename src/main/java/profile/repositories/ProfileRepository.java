package profile.repositories;

import lombok.AllArgsConstructor;
import profile.models.Profile;

import java.sql.*;

@AllArgsConstructor
public class ProfileRepository {
    Connection conn;

    public int createProfile(Profile profile) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into profile (name, document) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, profile.getName());
        ps.setString(2, profile.getDocument());
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
}
