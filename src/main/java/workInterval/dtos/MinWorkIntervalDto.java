package workInterval.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MinWorkIntervalDto {
    private int idWorkInterval;
    private int barberShopid;
}