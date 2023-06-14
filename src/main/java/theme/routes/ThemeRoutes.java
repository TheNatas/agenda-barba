package theme.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theme.controllers.*;
import theme.models.Theme;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThemeRoutes {
    @PostMapping("/theme")
    public ResponseEntity<Integer> createTheme(@RequestBody Theme theme) {
        return CreateThemeController.execute(theme);
    }

    @PutMapping("/theme")
    public ResponseEntity<Integer> updateTheme(@RequestBody Theme theme) {
        return UpdateThemeController.execute(theme);
    }

    @DeleteMapping("/theme/{id}")
    public ResponseEntity<Integer> deleteTheme(@PathVariable Integer id) {
        return DeleteThemeController.execute(id);
    }

    @GetMapping("/theme/{id}")
    public ResponseEntity<Theme> getTheme(@PathVariable Integer id) {
        return GetThemeController.execute(id);
    }

    @GetMapping("/themes")
    public ResponseEntity<List<Theme>> getThemesByBarberShop(@RequestParam(value = "barberShopId") Integer barberShopId) {
        return GetThemesFromBarberShopController.execute(barberShopId);
    }
}
