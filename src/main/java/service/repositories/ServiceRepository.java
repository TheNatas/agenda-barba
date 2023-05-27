package service.repositories;

import lombok.AllArgsConstructor;
import service.models.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Service getService(Integer id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from service s where s.id_services = ?");
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        Service service = null;
        while (rs.next()) {
            service = new Service();
            service.setIdService(rs.getInt(1));
            service.setPrice(rs.getDouble(2));
            service.setDescription(rs.getString(3));
            service.setName(rs.getString(4));
            service.setBarberShopId(rs.getInt(5));
            service.setDuration(rs.getInt(6));
        }

        return service;
    }

    public List<Service> getServicesByBarberShop(Integer barberShopId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from service s where s.barber_shop_id = ?");
        ps.setInt(1, barberShopId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        List<Service> services = new ArrayList<>();
        while (rs.next()) {
            Service service = new Service();
            service.setIdService(rs.getInt(1));
            service.setPrice(rs.getDouble(2));
            service.setDescription(rs.getString(3));
            service.setName(rs.getString(4));
            service.setBarberShopId(rs.getInt(5));
            service.setDuration(rs.getInt(6));
            services.add(service);
        }

        return services;
    }
}
