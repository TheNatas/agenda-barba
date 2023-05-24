package user.services;

import lombok.AllArgsConstructor;
import profile.models.Profile;
import profile.repositories.ProfileRepository;
import user.dtos.IncomingUserDto;
import user.models.User;
import user.repositories.UserRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class CreateUserService {
    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    public int execute(IncomingUserDto incomingUserDto) throws SQLException {
        Profile profile = Profile.builder()
                .name(incomingUserDto.getName())
                .document(incomingUserDto.getDocument())
                .build();

        Integer savedProfileId = this.profileRepository.createProfile(profile);

        User user = User.builder()
                .profileId(savedProfileId)
                .active(true)
                .email(incomingUserDto.getEmail())
                .password(incomingUserDto.getPassword())
                .build();

        return this.userRepository.createUser(user);
    }
}
