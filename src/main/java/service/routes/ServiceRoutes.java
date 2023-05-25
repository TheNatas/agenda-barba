package service.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.controllers.CreateServiceController;
import service.controllers.UpdateServiceController;
import service.models.Service;

@RestController
@RequestMapping("/api")
public class ServiceRoutes {
    @PostMapping("/service")
    public ResponseEntity<Integer> createService(@RequestBody Service service) {
        return CreateServiceController.execute(service);
    }

    @PutMapping("/service")
    public ResponseEntity<Integer> updateService(@RequestBody Service service) {
        return UpdateServiceController.execute(service);
    }
}
