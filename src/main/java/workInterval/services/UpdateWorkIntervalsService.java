package workInterval.services;

import workInterval.dtos.FullWorkIntervalDto;
import workInterval.repositories.WorkIntervalRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class UpdateWorkIntervalsService {
    private WorkIntervalRepository workIntervalRepository;

    public int execute(FullWorkIntervalDto workIntervalDto) throws SQLException {
        if (workIntervalDto.getStart().compareTo(workIntervalDto.getEnd()) < 0) {
            return this.workIntervalRepository.updateWorkInterval(workIntervalDto);
        } 
        else {
            throw new SQLException("start date bigger than end date");
        }
    }
}