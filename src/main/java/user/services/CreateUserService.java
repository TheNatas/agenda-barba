package user.services;

import lombok.AllArgsConstructor;
import profile.models.Profile;
import profile.repositories.ProfileRepository;
import user.dtos.NewUserDto;
import user.models.User;
import user.repositories.UserRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class CreateUserService {
    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    public int execute(NewUserDto newUserDto) throws SQLException {
        Profile profile = Profile.builder()
                .name(newUserDto.getName())
                .document(newUserDto.getDocument())
                .build();

        Integer savedProfileId = this.profileRepository.createProfile(profile);

        User user = User.builder()
                .profileId(savedProfileId)
                .active(true)
                .email(newUserDto.getEmail())
                .password(newUserDto.getPassword())
                .build();

        return this.userRepository.createUser(user);
    }
}
