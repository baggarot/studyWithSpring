package lesson39;

import lesson39.dao.Car;
import lesson39.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class LoggingAopRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(LoggingAopRunner.class, args);
        final CarService carService = applicationContext.getBean(CarService.class);
        final Car mustang = carService.getByName("Ford Mustang");
        log.info("Марка автомобиля {}", carService.getName());
    }
}
