package workInterval.services;

import workInterval.dtos.NewWorkIntervalDto;
import workInterval.repositories.WorkIntervalRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class InsertWorkIntervalsService {
    private WorkIntervalRepository workIntervalRepository;

    public int execute(NewWorkIntervalDto workIntervalDto) throws SQLException {
        if (workIntervalDto.getStart().compareTo(workIntervalDto.getEnd()) < 0) {
            return this.workIntervalRepository.insertWorkInterval(workIntervalDto);
        } 
        else {
            return this.workIntervalRepository.badRequest().build()
        }
    }
}
