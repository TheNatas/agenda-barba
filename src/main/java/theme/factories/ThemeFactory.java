package theme.factories;

import lombok.Builder;
import theme.repositories.ThemeRepository;
import theme.services.*;

import java.sql.Connection;

@Builder
public class ThemeFactory {
    private Connection conn;

    public CreateThemeService getCreateThemeService() {
        return new CreateThemeService(this.getThemeRepository());
    }

    public UpdateThemeService getUpdateThemeService() {
        return new UpdateThemeService(this.getThemeRepository());
    }

    public DeleteThemeService getDeleteThemeService() {
        return new DeleteThemeService(this.getThemeRepository());
    }

    public GetThemeService getThemeService() {
        return new GetThemeService(this.getThemeRepository());
    }

    public GetThemesFromBarberShopService getThemesFromBarberShopService() {
        return new GetThemesFromBarberShopService(this.getThemeRepository());
    }

    private ThemeRepository getThemeRepository() {
        return new ThemeRepository(conn);
    }
}
