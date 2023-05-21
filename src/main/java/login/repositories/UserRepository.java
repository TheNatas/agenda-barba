package login.repositories;

import lombok.AllArgsConstructor;

import java.sql.Connection;

@AllArgsConstructor
public class UserRepository {
    private Connection conn;

//    private String getUsersNames() {
//        conn.createStatement().execute("select * from user");
//    }
}
