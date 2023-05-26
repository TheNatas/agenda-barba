package workInterval.models;


import java.sql.Timestamp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class WorkInterval{
    private int idWorkInterval;
    private int barberShopid;
    private String weekDay;
    private Timestamp start;
    private Timestamp end;
}