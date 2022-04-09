package lesson39.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {

    private String model;
    private double weight;
    private double width;
    private double length;

    public Car(String model) {
        this.model = model;
        this.weight = Math.random() * 2;
        this.width = Math.random() * 4;
        this.length = Math.random() * 7;
    }
}
