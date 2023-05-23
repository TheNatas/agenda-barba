package schedule.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class ScheduleEntity {
    private Integer id_service;
    private Integer employee_id;
    private Integer user_id;
    private String admin_status;
    private Integer barber_shop_id;
}
