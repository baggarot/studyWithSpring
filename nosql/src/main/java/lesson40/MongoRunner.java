package lesson40;

import lesson40.dto.CityDto;
import lesson40.service.CityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MongoRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(MongoRunner.class, args);
        final CityService cityService = applicationContext.getBean(CityService.class);
        cityService.save(new CityDto(383, "Новосибирск", 1621330));
        cityService.save(new CityDto(3812, "Омск", 1139897));
    }
}
