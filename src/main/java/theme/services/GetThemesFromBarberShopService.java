package theme.services;

import lombok.AllArgsConstructor;
import theme.models.Theme;
import theme.repositories.ThemeRepository;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class GetThemesFromBarberShopService {
    private ThemeRepository themeRepository;

    public List<Theme> execute(Integer barberShopId) throws SQLException {
        return this.themeRepository.getThemesByBarberShop(barberShopId);
    }
}
