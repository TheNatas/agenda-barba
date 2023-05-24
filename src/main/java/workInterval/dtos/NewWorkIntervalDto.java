package workInterval.dtos;


import java.sql.Timestamp;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class NewWorkIntervalDto {
    private int barberShopid;
    private String weekDay;
    private Timestamp start;
    private Timestamp end;
}
