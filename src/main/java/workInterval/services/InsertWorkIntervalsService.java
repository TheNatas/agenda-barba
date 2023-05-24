package workInterval.services;

import workInterval.dtos.NewWorkIntervalDto;
import workInterval.repositories.WorkIntervalRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class InsertWorkIntervalsService {
    private WorkIntervalRepository workIntervalRepository;

    public int execute(NewWorkIntervalDto workIntervalEntity) throws SQLException {
        return this.workIntervalRepository.insertWorkInterval(workIntervalEntity);
    }
}
