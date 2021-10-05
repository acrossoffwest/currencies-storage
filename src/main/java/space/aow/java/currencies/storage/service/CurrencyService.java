package space.aow.java.currencies.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.aow.java.currencies.storage.entities.Currency;
import space.aow.java.currencies.storage.entities.Exchange;
import space.aow.java.currencies.storage.repository.CurrencyRepository;

import java.sql.Timestamp;
import java.util.*;

@Service
public class CurrencyService implements CurrencyServiceInterface {
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ExchangeService exchangeService;

    @Override
    public List<Currency> findAllWithExchangesBetween(Timestamp start, Timestamp end) {
        List<Currency> currencies = findAll();

        for (Currency currency: currencies) {
            currency.setExchanges(exchangeService.findByCreatedAtBetween(start, end));
        }

        return currencies;
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Optional<Currency> findByCode(String code) {
        return currencyRepository.findByCode(code);
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public List<Currency> saveAll(List<Currency> currencies) {
        List<Currency> result = new ArrayList<>();

        for (Currency savingCurrency: currencies) {
            Optional<Currency> optionalCurrency = findByCode(savingCurrency.getCode());
            List<Exchange> exchanges = savingCurrency.getExchanges();
            savingCurrency.setExchanges(null);
            Currency currency = optionalCurrency.orElseGet(() -> save(savingCurrency));
            currency.setExchanges(exchangeService.saveAll(exchanges, currency));
            result.add(currency);
        }

        return result;
    }
}
