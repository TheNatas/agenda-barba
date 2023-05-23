package login.routes;

import login.controllers.LoginController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginRoutes {

    @GetMapping("/login")
    public ResponseEntity<List<String>> Hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return LoginController.execute(name);
    }

}
