package service.factories;

import lombok.Builder;
import service.repositories.ServiceRepository;
import service.services.*;

import java.sql.Connection;

@Builder
public class ServiceFactory {
    Connection conn;

    public CreateServiceService getCreateServiceService() {
        return new CreateServiceService(this.getServiceRepository());
    }

    public UpdateServiceService getUpdateServiceService() {
        return new UpdateServiceService(this.getServiceRepository());
    }

    public DeleteServiceService getDeleteServiceService() {
        return new DeleteServiceService(this.getServiceRepository());
    }

    public GetServiceService getServiceService() {
        return new GetServiceService(this.getServiceRepository());
    }

    public GetServicesByBarberShopService getServicesByBarberShopService() {
        return new GetServicesByBarberShopService(this.getServiceRepository());
    }

    private ServiceRepository getServiceRepository() {
        return new ServiceRepository(conn);
    }
}
