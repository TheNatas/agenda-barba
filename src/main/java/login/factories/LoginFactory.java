package login.factories;

import login.repositories.UserRepository;
import login.services.LoginService;
import java.sql.Connection;
import lombok.Builder;

@Builder
public class LoginFactory {
    private Connection conn;

    public LoginService getLoginService() {
        return new LoginService(this.getUserRepository());
    }

    private UserRepository getUserRepository() {
        return new UserRepository(conn);
    }
}
