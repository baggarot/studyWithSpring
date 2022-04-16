package lesson41.model;

import com.ibm.icu.text.Transliterator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document(collection = "city")
public class City {

    @Id
    private String cityCode;

    @NotEmpty
    private String cityName;

    @NotEmpty
    private String cityNameInEnglish;

    @NotNull
    private int numberOfResidents;

    public City(String cityCode, String cityName, int numberOfResidents) {
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