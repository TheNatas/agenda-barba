package theme.services;

import lombok.AllArgsConstructor;
import theme.models.Theme;
import theme.repositories.ThemeRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class GetThemeService {
    private ThemeRepository themeRepository;

    public Theme execute(Integer id) throws SQLException {
        return this.themeRepository.getTheme(id);
    }
}
