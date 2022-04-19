package lesson42.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

@SpringBootTest
@DisplayName("Контроллер городов")
public class CityControllerTest {

    private RouterFunction route;

    @Test
    public void testApiRoute() {
        WebTestClient client = WebTestClient
                .bindToRouterFunction(route)
                .build();
        client.get()
                .uri("api/cities")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
