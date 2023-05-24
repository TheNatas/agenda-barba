package login.services;

import login.dtos.LoggedUserDto;
import login.dtos.LoginDto;
import login.entities.LoggedUserEntity;
import login.repositories.UserRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class LoginService {
    private UserRepository userRepository;

    public LoggedUserEntity execute(LoginDto loginDto) throws SQLException {
        return this.userRepository.getLoggedUser(loginDto.getEmail(), loginDto.getPassword());
    }
}
