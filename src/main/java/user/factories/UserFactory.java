package user.factories;

import lombok.Builder;
import profile.repositories.ProfileRepository;
import user.repositories.UserRepository;
import user.services.CreateUserService;
import user.services.UpdateUserService;

import java.sql.Connection;

@Builder
public class UserFactory {
    Connection conn;

    public CreateUserService getCreateUserService() {
        return new CreateUserService(this.getUserRepository(), this.getProfileRepository());
    }

    public UpdateUserService getUpdateUserService() {
        return new UpdateUserService(this.getUserRepository(), this.getProfileRepository());
    }

    private UserRepository getUserRepository() {
        return new UserRepository(conn);
    }

    private ProfileRepository getProfileRepository() {
        return new ProfileRepository(conn);
    }
}
