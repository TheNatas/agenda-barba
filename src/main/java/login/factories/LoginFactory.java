package login.factories;

import login.services.LoginService;
import java.sql.Connection;
import lombok.Builder;

@Builder
public class LoginFactory {
    private Connection conn;

    public LoginService getLoginService() {
        return new LoginService();
    }
}
