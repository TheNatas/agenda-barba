package login.routes;

import login.controllers.LoginController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Login {

    @GetMapping("/login")
    public ResponseEntity Hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return LoginController.execute(name);
    }

}
