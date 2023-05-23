package barberShop.routes;

import barberShop.controllers.GetBarberShopInfoController;
import barberShop.entities.BarberShopEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BarberShopRoutes {

    @GetMapping("/barberShop")
    public ResponseEntity<BarberShopEntity> getBarberShopInfo(@RequestParam(value = "id", defaultValue = "-1") Integer id) {
        return GetBarberShopInfoController.execute(id);
    }

}
