package login.repositories;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
