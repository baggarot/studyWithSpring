package lesson43.model;

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
    private int code;

    @NotEmpty
    @Column(name = "city_name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "city_name_in_English", nullable = false)
    private String nameInEnglish;

    @NotNull
    @Column(name = "number_of_residents", nullable = false)
    private int numberOfResidents;

    public City(int code, String name, int numberOfResidents) {
        this.code = code;
        this.name = name;
        this.nameInEnglish = translate(name);
        this.numberOfResidents = numberOfResidents;
    }

    private String translate(String name) {
        var cyrillicToLatin = "Russian-Latin/BGN";
        Transliterator toLatinTrans = Transliterator.getInstance(cyrillicToLatin);
        return toLatinTrans.transliterate(name);
    }
}
