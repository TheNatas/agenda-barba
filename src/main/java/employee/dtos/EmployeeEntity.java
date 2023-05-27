package employee.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class EmployeeEntity {
    private Integer idEmployee;
    private Integer userId;
    private Boolean adminStatus;
    private Integer barberShopId;
    private String name;
}
