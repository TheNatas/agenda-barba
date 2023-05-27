package service.services;

import lombok.AllArgsConstructor;
import service.models.Service;
import service.repositories.ServiceRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class GetServiceService {
    private ServiceRepository serviceRepository;

    public Service execute(Integer id) throws SQLException {
        return this.serviceRepository.getService(id);
    }
}
