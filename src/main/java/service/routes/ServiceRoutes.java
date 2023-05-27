package service.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.controllers.*;
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

    @DeleteMapping("/service/{id}")
    public ResponseEntity<Integer> deleteService(@PathVariable Integer id) {
        return DeleteServiceController.execute(id);
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
