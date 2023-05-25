package profile.repositories;

import lombok.AllArgsConstructor;
import profile.models.Profile;

import java.sql.*;

@AllArgsConstructor
public class ProfileRepository {
    Connection conn;

    public Profile getProfile(Integer id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from profile p where p.id_profile = ?");
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        Profile profile = null;
        while (rs.next()) {
            profile = new Profile();
            profile.setIdProfile(rs.getInt("id_profile"));
            profile.setName(rs.getString("name"));
            profile.setDocument(rs.getString("document"));
        }

        return profile;
    }

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
                throw new SQLException("Creating profile failed, no ID obtained.");
            }
        }
    }

    public int updateProfile(Profile profile) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update profile set name = ?, document = ? where id_profile = ?", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, profile.getName());
        ps.setString(2, profile.getDocument());
        ps.setInt(3, profile.getIdProfile());
        return ps.execute() ? 1 : 0;
    }
}
