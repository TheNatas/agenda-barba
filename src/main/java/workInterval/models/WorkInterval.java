package workInterval.models;


import java.sql.Time;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class WorkInterval{
    private int idWorkInterval;
    private int barberShopId;
    private String weekDay;
    private Time start;
    private Time end;
}