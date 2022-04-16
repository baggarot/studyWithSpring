package lesson41.controller;

import lesson41.dto.CityDto;
import lesson41.mapper.CityMapper;
import lesson41.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
@Controller
@RequiredArgsConstructor
public class CityPageController {

    private CityRepository repository;
    private CityMapper mapper;

    @GetMapping("/cities")
    public String index() {
        return "city/cities";
    }

    @GetMapping("/city/add")
    public String newCity() {
        return "city/city";
    }

    @GetMapping("/city/edit")
    public String currentCity(@RequestParam("code") String cityCode, Model model) {
        model.addAttribute("city", repository.findById(cityCode));
        return "city/city";
    }

    @PostMapping("/city/save")
    public Mono<String> saveCity(@Valid CityDto city) {
        return repository.save(mapper.toEntity(city)).map(c ->
                "redirect:/cities"
        );
    }
}
