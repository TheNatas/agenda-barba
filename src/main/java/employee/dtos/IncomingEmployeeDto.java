package employee.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class IncomingEmployeeDto {
    private Integer idEmployee;
    private Integer userId;
    private Boolean adminStatus;
    private Integer barberShopId;
    private Integer profileId;
    private String email;
    private String password;
    private String name;
    private String document;
}
