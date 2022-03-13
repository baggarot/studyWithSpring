package lesson33.service;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExchangesRatesService {

    double currencyConverter(String valute, double currency) throws IOException;
}
