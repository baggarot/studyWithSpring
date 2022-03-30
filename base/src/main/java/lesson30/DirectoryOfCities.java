package lesson30;

import lesson30.model.City;
import lesson30.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class DirectoryOfCities {

    private final CityService cityService;

    @ShellMethod(value = "add")
    public void add(String code, String name, String number) {
        int cityCode = Integer.parseInt(code);
        int numberOfResidents = Integer.parseInt(number);
        cityService.add(new City(cityCode, name, numberOfResidents));
    }

    @ShellMethod(value = "delete")
    public void delete(String code, String name, String number) {
        int cityCode = Integer.parseInt(code);
        int numberOfResidents = Integer.parseInt(number);
        cityService.delete(new City(cityCode, name, numberOfResidents));
    }

    @ShellMethod(value = "read")
    public void read() {
        cityService.allCities();
    }
}
