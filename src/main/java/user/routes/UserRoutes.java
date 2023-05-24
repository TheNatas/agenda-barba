package user.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.controllers.CreateUserController;
import user.controllers.UpdateUserController;
import user.dtos.IncomingUserDto;

@RestController
@RequestMapping("/api")
public class UserRoutes {
    @PostMapping("/user")
    public ResponseEntity<Integer> createUser(@RequestBody IncomingUserDto incomingUserDto) {
        return CreateUserController.execute(incomingUserDto);
    }

    @PutMapping("/user")
    public ResponseEntity<Integer> updateUser(@RequestBody IncomingUserDto incomingUserDto) {
        return UpdateUserController.execute(incomingUserDto);
    }
}
