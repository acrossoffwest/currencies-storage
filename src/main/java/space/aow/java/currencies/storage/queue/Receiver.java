package space.aow.java.currencies.storage.queue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import space.aow.java.currencies.storage.entities.Currency;
import space.aow.java.currencies.storage.service.CurrencyServiceInterface;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    private final CurrencyServiceInterface currencyService;
    private final ObjectMapper mapper = new ObjectMapper();
    private final CountDownLatch latch = new CountDownLatch(1);

    public Receiver(CurrencyServiceInterface currencyService) {
        this.currencyService = currencyService;
    }

    public void handleMessage(List<Object> currenciesMap) throws IOException, ClassNotFoundException {
        try {
            currencyService.saveAll(convertListOfObjectToListOfCurrencies(currenciesMap));
        } catch (IllegalArgumentException exception) {

        }
    }

    private List<Currency> convertListOfObjectToListOfCurrencies(List<Object> currencies)
    {
        return mapper.convertValue(currencies, new TypeReference<List<Currency>>() {});
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
