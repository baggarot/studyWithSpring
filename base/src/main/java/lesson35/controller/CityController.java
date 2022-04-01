package lesson35.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lesson30.service.CityService;
import lesson35.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping("/test")
    @Operation(summary = "Приветсвенный сервис")
    public String hello(@Parameter(description = "Инициатор запроса", required = true)
                            @RequestParam String initiator) {
        return String.format("Hello, %s", initiator);
    }

    @GetMapping("/api/secured")
    public String secured() {
        return "test";
    }

    @Operation(summary = "Удаление элемента")
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long cityId) {
        cityService.deleteById(cityId);
        return ResponseEntity.ok(new CityDto());
    }
}
