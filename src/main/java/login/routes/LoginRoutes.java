package login.routes;

import login.controllers.LoginController;
import login.dtos.LoginDto;
import login.entities.LoggedUserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginRoutes {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return LoginController.execute(loginDto);
    }

}
