package service.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Service {
    private Integer idService;
    private Double price;
    private String description;
    private String name;
    private Integer barberShopId;
    private Integer duration;
}
