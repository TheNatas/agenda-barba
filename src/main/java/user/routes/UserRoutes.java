package user.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.controllers.CreateUserController;
import user.dtos.NewUserDto;

@RestController
@RequestMapping("/api")
public class UserRoutes {
    @PostMapping("/user")
    public ResponseEntity<Integer> createUser(@RequestBody NewUserDto newUserDto) {
        return CreateUserController.execute(newUserDto);
    }
}
