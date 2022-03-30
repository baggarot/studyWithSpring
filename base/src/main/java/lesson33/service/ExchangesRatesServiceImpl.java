package lesson33.service;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ExchangesRatesServiceImpl implements ExchangesRatesService {

    @Override
    public double currencyConverter(String valute, double currency) throws IOException {
        URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStream inputStream = connection.getInputStream();
        DocumentContext jsonContext = JsonPath.parse(inputStream);
        Double jsonCreatorValue = jsonContext.read("$.Valute." + valute + ".Value");
        return currency * jsonCreatorValue;
    }
}
