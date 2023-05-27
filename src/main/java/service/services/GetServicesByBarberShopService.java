package service.services;

import lombok.AllArgsConstructor;
import service.models.Service;
import service.repositories.ServiceRepository;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class GetServicesByBarberShopService {
    private ServiceRepository serviceRepository;

    public List<Service> execute(Integer barberShopId) throws SQLException {
        return this.serviceRepository.getServicesByBarberShop(barberShopId);
    }
}
