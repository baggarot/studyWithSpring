package lesson42.repository;

import lesson41.model.City;
import lesson41.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class CityRepositoryTest {

    private CityRepository cityRepository;

    @Test
    public void shouldSaveNewCity() {
        Mono<City> cityMono = cityRepository.save(new City("383", "Новосибирск",
                1568913));
        StepVerifier
                .create(cityMono)
                .assertNext(city -> assertThat(city.getCityCode()).isNotEmpty())
                .expectComplete()
                .verify();
    }

    @Test
    public void shouldSaveAndFindByCode() {
        cityRepository.save(new City("383", "Новосибирск",
                1568913)).subscribe(System.out::println);
        StepVerifier.create(cityRepository.deleteById("383"))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}
