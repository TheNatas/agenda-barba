package service.services;

import lombok.AllArgsConstructor;
import service.repositories.ServiceRepository;

import java.sql.SQLException;

@AllArgsConstructor
public class DeleteServiceService {
    private ServiceRepository serviceRepository;

    public int execute(Integer id) throws SQLException {
        return this.serviceRepository.delete(id);
    }
}
