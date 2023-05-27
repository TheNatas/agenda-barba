package barberShop.routes;

import barberShop.controllers.GetBarberShopInfoController;
import barberShop.entities.BarberShopEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BarberShopRoutes {

    @GetMapping("/barberShop/{id}")
    public ResponseEntity<BarberShopEntity> getBarberShopInfo(@PathVariable Integer id) {
        return GetBarberShopInfoController.execute(id);
    }

}
