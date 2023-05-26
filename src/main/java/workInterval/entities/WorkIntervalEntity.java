package workInterval.entities;

import java.sql.Timestamp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class WorkIntervalEntity {
    private int idWorkInterval;
    private int barberShopid;
    private String weekDay;
    private Timestamp start;
    private Timestamp end;
}