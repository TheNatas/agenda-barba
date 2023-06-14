package theme.services;

import lombok.AllArgsConstructor;
import theme.models.Theme;
import theme.repositories.ThemeRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class CreateThemeService {
    private ThemeRepository themeRepository;

    public int execute(Theme theme) throws SQLException {
        return this.themeRepository.createTheme(theme);
    }
}
