package lesson35.controller;

import io.swagger.v3.oas.annotations.Operation;
import lesson30.service.CityService;
import lesson35.dto.CityDto;
import lesson35.dto.CityPageDto;
import lesson35.validator.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
public class CityPageController {

    private final CityService cityService;

    @GetMapping("/cities")
    public String index(Model model,
                        @PositiveOrZero(originValue = 15) @RequestParam(required = false,
                                defaultValue = "0") Integer page,
                        @Positive @RequestParam(required = false,
                                defaultValue = "5") Integer size) {
        CityPageDto allGenres = cityService.getPage(PageRequest.of(page, size));
        model.addAttribute("cities", allGenres);
        return "city/cities";
    }

    @Operation(summary = "Новый объект")
    @GetMapping("/city/add")
    public String newCity(Model model) {
        return "city/city";
    }

    @Operation(summary = "Редактирование объекта")
    @GetMapping("/city/edit")
    public String currentCity(@RequestParam("id") Long cityId, Model model) {
        CityDto currentCity = cityService.getByCityId(cityId)
                .orElseThrow(() -> new IllegalArgumentException("Non existed city"));
        model.addAttribute("city", currentCity);
        return "city/city";
    }

    @Operation(summary = "Сохранение объекта")
    @PostMapping("/city/save")
    public String saveCity(CityDto city) {
        cityService.save(city);
        return "redirect:/cities";
    }
}
