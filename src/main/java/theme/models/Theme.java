package theme.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Theme {
    private Integer idTheme;
    private String backgroundColor;
    private String primaryColor;
    private String secondaryColor;
    private String highlightColor;
    private String textColor;
    private String textContrast;
    private String imageUrl;
    private Integer barberShopId;
}
