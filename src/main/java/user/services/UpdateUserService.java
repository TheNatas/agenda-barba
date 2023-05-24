package user.services;

import lombok.AllArgsConstructor;
import profile.models.Profile;
import profile.repositories.ProfileRepository;
import user.dtos.IncomingUserDto;
import user.models.User;
import user.repositories.UserRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class UpdateUserService {
    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    public int execute(IncomingUserDto incomingUserDto) throws SQLException {
        User savedUser = this.userRepository.getUser(incomingUserDto.getUserId());

        final boolean isSavedUserDifferentFromIncoming =
                (incomingUserDto.getEmail() != null && !savedUser.getEmail().equals(incomingUserDto.getEmail())) ||
                        incomingUserDto.getPassword() != null && !savedUser.getPassword().equals(incomingUserDto.getPassword());

        if (isSavedUserDifferentFromIncoming) {
            this.userRepository.updateUser(
                    User.builder()
                            .idUser(savedUser.getIdUser())
                            .profileId(savedUser.getProfileId())
                            .active(savedUser.getActive())
                            .email(incomingUserDto.getEmail())
                            .password(incomingUserDto.getPassword())
                            .build()
            );
        }

        Profile savedProfile = this.profileRepository.getProfile(savedUser.getProfileId());

        final boolean isSavedProfileDifferentFromIncoming =
                (savedProfile.getName() != null && !savedProfile.getName().equals(incomingUserDto.getName())) ||
                        (savedProfile.getDocument() != null && !savedProfile.getDocument().equals(incomingUserDto.getDocument()));

        if (isSavedProfileDifferentFromIncoming) {
            this.profileRepository.updateProfile(
                    Profile.builder()
                            .idProfile(savedProfile.getIdProfile())
                            .name(incomingUserDto.getName())
                            .document(incomingUserDto.getDocument())
                            .build()
            );
        }

        return 1;
    }
}
