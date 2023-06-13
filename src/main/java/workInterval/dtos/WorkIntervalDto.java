package workInterval.dtos;

import lombok.*;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class WorkIntervalDto {
    private String weekDay;
    private Time start;
    private Time end;
}
