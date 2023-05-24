package workInterval.services;

import workInterval.entities.WorkIntervalEntity;
import workInterval.repositories.WorkIntervalRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class InsertWorkIntervalsService {
    private WorkIntervalRepository workIntervalRepository;

    public int execute(WorkIntervalEntity workIntervalEntity) throws SQLException {
        return this.workIntervalRepository.insertWorkInterval(workIntervalEntity);
    }
}
