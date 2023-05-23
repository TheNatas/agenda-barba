package barberShop.repositories;

import barberShop.entities.BarberShopEntity;
import lombok.AllArgsConstructor;

import java.sql.*;

@AllArgsConstructor
public class BarberShopRepository {
    private Connection conn;

    public BarberShopEntity getBarberShopInfo(Integer barberShopId) throws SQLException {
        String query = "select " +
                "bs.id_barber_shop, bs.shop_name, a.address_desc, a.address_number, a.address_complement, a.address_code, c.city_name, s.state_name, co.country_name " +
                "from barber_shop bs " +
                "left join address a on (a.id_address = bs.address_id) " +
                "left join city c on (c.id_city = a.city_id) " +
                "left join state s on (s.id_state = c.state_id) " +
                "left join country co on (co.id_country = s.country_id) " +
                "where bs.id_barber_shop = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, barberShopId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        BarberShopEntity barberShopEntity = new BarberShopEntity();
        while (rs.next()) {
            barberShopEntity.setIdBarberShop(rs.getInt(1));
            barberShopEntity.setShopName(rs.getString(2));
            barberShopEntity.setAddressDesc(rs.getString(3));
            barberShopEntity.setAddressNumber(rs.getInt(4));
            barberShopEntity.setAddressComplement(rs.getString(5));
            barberShopEntity.setAddressCode(rs.getString(6));
            barberShopEntity.setCityName(rs.getString(7));
            barberShopEntity.setStateName(rs.getString(8));
            barberShopEntity.setCountryName(rs.getString(9));
        }

        return barberShopEntity;
    }
}
