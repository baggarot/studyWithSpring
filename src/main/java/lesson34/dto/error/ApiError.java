package lesson34.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ApiError {

    private String code;
    private String message;
    private List<Field> fields = new ArrayList<>();

    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class Field {

        private String code;
        private String message;
    }

    public void addField(String name, String message) {
        fields.add(new Field(name, message));
    }
}
