package theme.services;

import lombok.AllArgsConstructor;
import theme.repositories.ThemeRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class DeleteThemeService {
    private ThemeRepository themeRepository;

    public int execute(Integer id) throws SQLException {
        return this.themeRepository.deleteTheme(id);
    }
}
