package user.factories;

import lombok.Builder;
import profile.repositories.ProfileRepository;
import user.repositories.UserRepository;
import user.services.CreateUserService;

import java.sql.Connection;

@Builder
public class UserFactory {
    Connection conn;

    public CreateUserService getCreateUserService() {
        return new CreateUserService(this.getUserRepository(), this.getProfileRepository());
    }

    private UserRepository getUserRepository() {
        return new UserRepository(conn);
    }

    private ProfileRepository getProfileRepository() {
        return new ProfileRepository(conn);
    }
}
