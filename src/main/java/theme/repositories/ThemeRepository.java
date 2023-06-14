package theme.repositories;

import lombok.AllArgsConstructor;
import theme.models.Theme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ThemeRepository {
    private Connection conn;

    public int createTheme(Theme theme) throws SQLException {
        String query = "insert into theme (" +
                "background_color, primary_color, secondary_color, highlight_color, text_color, text_contrast, image_url, barber_shop_id" +
                ") values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, theme.getBackgroundColor());
        ps.setString(2, theme.getPrimaryColor());
        ps.setString(3, theme.getSecondaryColor());
        ps.setString(4, theme.getHighlightColor());
        ps.setString(5, theme.getTextColor());
        ps.setString(6, theme.getTextContrast());
        ps.setString(7, theme.getImageUrl());
        ps.setInt(8, theme.getBarberShopId());
        ps.execute();

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating profile failed, no ID obtained.");
            }
        }
    }

    public int updateTheme(Theme theme) throws SQLException{
        String query = "update theme " +
                "set background_color = ?, primary_color = ?, secondary_color = ?, highlight_color = ?, text_color = ?, text_contrast = ?, image_url = ? " +
                "where id_theme = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, theme.getBackgroundColor());
        ps.setString(2, theme.getPrimaryColor());
        ps.setString(3, theme.getSecondaryColor());
        ps.setString(4, theme.getHighlightColor());
        ps.setString(5, theme.getTextColor());
        ps.setString(6, theme.getTextContrast());
        ps.setString(7, theme.getImageUrl());
        ps.setInt(8, theme.getIdTheme());
        return ps.executeUpdate();
    };

    public int deleteTheme(Integer id) throws SQLException{
        String query = "delete from theme " +
                "where id_theme = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        return ps.executeUpdate();
    };

    public Theme getTheme(Integer id) throws SQLException {
        String query = "select " +
                "id_theme, background_color, primary_color, secondary_color, highlight_color, text_color, text_contrast, image_url, barber_shop_id " +
                "from theme t " +
                "where t.id_theme = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        Theme theme = null;
        while (rs.next()) {
            theme = Theme.builder()
                    .idTheme(rs.getInt(1))
                    .backgroundColor(rs.getString(2))
                    .primaryColor(rs.getString(3))
                    .secondaryColor(rs.getString(4))
                    .highlightColor(rs.getString(5))
                    .textColor(rs.getString(6))
                    .textContrast(rs.getString(7))
                    .imageUrl(rs.getString(8))
                    .barberShopId(rs.getInt(9))
                    .build();
        }
        return theme;
    }

    public List<Theme> getThemesByBarberShop(Integer barberShopId) throws SQLException {
        String query = "select " +
                "id_theme, background_color, primary_color, secondary_color, highlight_color, text_color, text_contrast, image_url, barber_shop_id " +
                "from theme t " +
                "where t.barber_shop_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, barberShopId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        List<Theme> themes = new ArrayList<>();
        while (rs.next()) {
            themes.add(
                    Theme.builder()
                            .idTheme(rs.getInt(1))
                            .backgroundColor(rs.getString(2))
                            .primaryColor(rs.getString(3))
                            .secondaryColor(rs.getString(4))
                            .highlightColor(rs.getString(5))
                            .textColor(rs.getString(6))
                            .textContrast(rs.getString(7))
                            .imageUrl(rs.getString(8))
                            .barberShopId(rs.getInt(9))
                            .build()
            );
        }
        return themes;
    }
}
