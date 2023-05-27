package service.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.controllers.CreateServiceController;
import service.controllers.GetServiceController;
import service.controllers.GetServicesByBarberShopController;
import service.controllers.UpdateServiceController;
import service.models.Service;

import java.util.List;

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

    @GetMapping("/service/{id}")
    public ResponseEntity<Service> getService(@PathVariable Integer id) {
        return GetServiceController.execute(id);
    }

    @GetMapping("/services")
    public ResponseEntity<List<Service>> getServicesByBarberShop(@RequestParam(value = "barberShopId") Integer barberShopId) {
        return GetServicesByBarberShopController.execute(barberShopId);
    }
}
