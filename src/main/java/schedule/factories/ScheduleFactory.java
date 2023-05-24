package schedule.factories;

import schedule.repositories.ScheduleRepository;
import schedule.services.ScheduleService;
import lombok.Builder;

import java.sql.Connection;

@Builder
public class ScheduleFactory {
    Connection conn;

    public ScheduleService getScheduleService() {
        return new ScheduleService(this.getScheduleRepository());
    }

    private ScheduleRepository getScheduleRepository() {
        return new ScheduleRepository(conn);
    }
}