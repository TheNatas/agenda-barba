package workInterval.services;

import lombok.AllArgsConstructor;
import workInterval.dtos.WorkIntervalDto;
import workInterval.enums.WeekDayEnum;
import workInterval.repositories.WorkIntervalRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetWorkIntervalsByBarberShopService {
    private WorkIntervalRepository workIntervalRepository;

    public List<WorkIntervalDto> execute(Integer barberShopId) throws SQLException {
        return this.workIntervalRepository.getWorkIntervalsByBarberShop(barberShopId)
                .stream()
                .map(
                        workInterval -> WorkIntervalDto.builder()
                                .weekDay(WeekDayEnum.valueOf(workInterval.getWeekDay()).getAlias())
                                .start(workInterval.getStart())
                                .end(workInterval.getEnd())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
