package workInterval.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum WeekDayEnum {
    MONDAY("Segunda"),
    TUESDAY("Terça"),
    WEDNESDAY("Quarta"),
    THURSDAY("Quinta"),
    FRIDAY("Sexta");

    private String alias;
}
