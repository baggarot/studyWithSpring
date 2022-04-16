package lesson41;

import lesson41.model.City;
import lesson41.repository.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@EnableMongoRepositories
@SpringBootApplication
public class WebFluxRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxRunner.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> composeRouters(CityRepository cityRepository) {
        return route()
                .GET("/api/cities", accept(MediaType.APPLICATION_JSON),
                        request -> ok().contentType(MediaType.APPLICATION_JSON).body(cityRepository.findAll(), City.class)
                )
                .DELETE("/api/cities/{code}",
                        request -> cityRepository.deleteById(request.pathVariable("code")).flatMap(v -> ok().build())
                ).build();
    }
}
