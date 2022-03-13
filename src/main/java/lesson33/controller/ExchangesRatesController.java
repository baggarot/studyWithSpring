package lesson33.controller;

import lesson33.dto.ResultDto;
import lesson33.service.ExchangesRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencyConverter")
public class ExchangesRatesController {

    private final ExchangesRatesService service;

    @PostMapping("/converter")
    public ResultDto converter(@RequestParam("valute") String valute,
                               @RequestParam("currency")double value) throws IOException {
        return new ResultDto(service.currencyConverter(valute, value));
    }
}
