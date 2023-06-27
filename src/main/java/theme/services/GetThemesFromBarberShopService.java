package theme.services;

import lombok.AllArgsConstructor;
import theme.models.Theme;
import theme.repositories.ThemeRepository;
import utils.Notification;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class GetThemesFromBarberShopService {
    private ThemeRepository themeRepository;

    public List<Theme> execute(Integer barberShopId) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 5);
        Date dt = calendar.getTime();

        try {
            Notification.send("essa aqui eh pra mandar 23:49", "ok", "ykTFk4LVqoTDg3lgG6wS-l", dt);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return this.themeRepository.getThemesByBarberShop(barberShopId);
    }
}
