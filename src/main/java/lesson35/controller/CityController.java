package lesson35.controller;

import lesson30.service.CityService;
import lesson35.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CityController {

    private CityService cityService;

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long cityId) {
        cityService.deleteById(cityId);
        return ResponseEntity.ok(new CityDto());
    }
}
