package lesson35.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CityDto {

    @NotNull
    private int id;

    @NotNull
    private int cityCode;

    @NotNull
    @Size(min = 1, max = 120)
    private String cityName;

    @NotNull
    @Size(min = 1, max = 120)
    private String cityNameInEnglish;

    @NotNull
    private int numberOfResidents;
}
