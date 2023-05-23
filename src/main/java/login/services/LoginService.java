package login.services;

import login.repositories.UserRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class LoginService {
    private UserRepository userRepository;

    public List<String> execute(String name) throws SQLException {
        return this.userRepository.getUsersNames();
    }
}
