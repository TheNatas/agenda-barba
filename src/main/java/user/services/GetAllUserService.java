package user.services;

import lombok.AllArgsConstructor;
import profile.models.Profile;
import profile.repositories.ProfileRepository;
import user.dtos.IncomingUserDto;
import user.models.User;
import user.repositories.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;

@AllArgsConstructor
public class GetAllUserService {
    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    public ArrayList<User> execute() throws SQLException {
        return this.userRepository.getAllUsers();
    }
}
