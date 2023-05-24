package employee.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Employee {
    private Integer idEmployee;
    private Integer userId;
    private Boolean adminStatus;
    private Integer barberShopId;
}
