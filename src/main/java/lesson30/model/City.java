package lesson30.model;

import com.ibm.icu.text.Transliterator;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DIRECTORY_OF_CITIES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "city_code", nullable = false)
    private int cityCode;

    @NotEmpty
    @Column(name = "city_name", nullable = false)
    private String cityName;

    @NotEmpty
    @Column(name = "city_name_in_English", nullable = false)
    private String cityNameInEnglish;

    @NotNull
    @Column(name = "number_of_residents", nullable = false)
    private int numberOfResidents;

    public City(int cityCode, String cityName, int numberOfResidents) {
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
