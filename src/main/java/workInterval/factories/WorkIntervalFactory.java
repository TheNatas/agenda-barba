package workInterval.factories;

import workInterval.services.UpdateWorkIntervalsService;
import workInterval.services.DeleteWorkIntervalsService;
import workInterval.repositories.WorkIntervalRepository;
import workInterval.services.InsertWorkIntervalsService;
import lombok.Builder;

import java.sql.Connection;

@Builder
public class WorkIntervalFactory {
    Connection conn;

    public InsertWorkIntervalsService insertWorkIntervalsService() {
        return new InsertWorkIntervalsService(this.getWorkIntervalRepository()) ;
    }

    public WorkIntervalRepository getWorkIntervalRepository() {
        return new WorkIntervalRepository(conn);
    }

    public UpdateWorkIntervalsService updateWorkIntervalsService() {
        return new UpdateWorkIntervalsService(this.getWorkIntervalRepository());
    }

    public DeleteWorkIntervalsService deleteWorkIntervalsService() {
        return new DeleteWorkIntervalsService(this.getWorkIntervalRepository());
    }
}
