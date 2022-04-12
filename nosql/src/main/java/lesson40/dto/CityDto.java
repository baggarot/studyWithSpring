package lesson40.dto;

import com.ibm.icu.text.Transliterator;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CityDto {

    @NotNull
    @Size(min = 1, max = 6)
    private int cityCode;

    @NotNull
    @Size(min = 1, max = 120)
    private String cityName;

    @NotNull
    @Size(min = 1, max = 120)
    private String cityNameInEnglish;

    @NotNull
    @Size(min = 1, max = 10)
    private int numberOfResidents;

    public CityDto(int cityCode, String cityName, int numberOfResidents) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.cityNameInEnglish = translate(cityName);
        this.numberOfResidents = numberOfResidents;
    }

    private String translate(String name) {
        var cyrillicToLatin = "Russian-Latin/BGN";
        Transliterator toLatinTrans = Transliterator.getInstance(cyrillicToLatin);
        return toLatinTrans.transliterate(name);
    }
}
