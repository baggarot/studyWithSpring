package lesson33;

import lesson33.service.ExchangesRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

@ShellComponent
@RequiredArgsConstructor
public class WebExchangesRates {

    private final ExchangesRatesService service;

    @ShellMethod("converter")
    public void converter(String valute, double value) throws IOException {
        System.out.println(service.currencyConverter(valute, value));
    }
}
