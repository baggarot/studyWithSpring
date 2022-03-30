package webRunner.controller;

import lesson35.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class RestTemplateController {

    private final RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/test")
    public String getInfo() {
        return restTemplate.getForObject(UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8181)
                .path("/test")
                .queryParam("initiator", applicationName)
                .build(Map.of()), String.class);
    }

    @GetMapping("/cities")
    public String getCommonData() {
        return Objects.requireNonNull(restTemplate.getForObject(UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8181)
                .path("/cities")
                .build(Map.of()), CityDto.class)).getCityName();
    }
}
