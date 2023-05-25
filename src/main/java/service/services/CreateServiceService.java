package service.services;

import lombok.AllArgsConstructor;
import service.models.Service;
import service.repositories.ServiceRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class CreateServiceService {
    private ServiceRepository serviceRepository;

    public int execute(Service service) throws SQLException {
        return this.serviceRepository.createService(service);
    }
}
