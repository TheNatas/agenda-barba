package schedule.entities;

import java.sql.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class ScheduleEntity {
    private Integer serviceId;
    private Integer employeeId;
    private Integer userId;
    private Date date;
    private String scheduleStatus;
    private Integer barberShopId;
}
