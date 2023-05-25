package service.repositories;

import lombok.AllArgsConstructor;
import service.models.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class ServiceRepository {
    Connection conn;

    public int createService(Service service) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into service (price, description, name, duration, barber_shop_id) values (?,?,?,?,?)");
        ps.setDouble(1, service.getPrice());
        ps.setString(2, service.getDescription());
        ps.setString(3, service.getName());
        ps.setInt(4, service.getDuration());
        ps.setInt(5, service.getBarberShopId());
        return ps.execute() ? 1 : 0;
    }

    public int updateService(Service service) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update service set price = ?, description = ?, name = ?, duration = ? where id_services = ?");
        ps.setDouble(1, service.getPrice());
        ps.setString(2, service.getDescription());
        ps.setString(3, service.getName());
        ps.setInt(4, service.getDuration());
        ps.setInt(5, service.getIdService());
        return ps.execute() ? 1 : 0;
    }
}
