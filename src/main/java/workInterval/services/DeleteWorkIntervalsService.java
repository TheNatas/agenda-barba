package workInterval.services;

import workInterval.dtos.MinWorkIntervalDto;
import workInterval.repositories.WorkIntervalRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class DeleteWorkIntervalsService {
    private WorkIntervalRepository workIntervalRepository;

    public int execute(MinWorkIntervalDto workIntervalDto) throws SQLException {
        return this.workIntervalRepository.deleteWorkInterval(workIntervalDto);
    }
}