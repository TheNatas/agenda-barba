package login.controllers;

import login.dtos.LoginDto;
import login.entities.LoggedUserEntity;
import login.factories.LoginFactory;
import login.response.ErrorResponse;
import login.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utils.Connector;

import java.net.URI;
import java.sql.Connection;

public class LoginController {
    public static ResponseEntity<?> execute(LoginDto loginDto) {
        try {
            // Verifica se o campo "email" é nulo ou vazio
            if (loginDto.getEmail() == null || loginDto.getEmail().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorResponse("O campo 'email' é obrigatório!"));
            }

            // Verifica se o campo "password" é nulo ou vazio
            if (loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorResponse("O campo 'password' é obrigatório!"));
            }

            Connector connector = new Connector();
            Connection conn = connector.getConnection();
            LoginService service = LoginFactory.builder().conn(conn).build().getLoginService();
            LoggedUserEntity response = service.execute(loginDto);

            if (response == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ErrorResponse("Usuário ou senha inválido!."));
            }

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(response)
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(response);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return ResponseEntity.badRequest().build();
        }
    }
}