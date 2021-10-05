package space.aow.java.currencies.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.aow.java.currencies.storage.entities.Currency;
import space.aow.java.currencies.storage.entities.Exchange;
import space.aow.java.currencies.storage.repository.ExchangeRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeService implements ExchangeServiceInterface{
    @Autowired
    ExchangeRepository repository;

    @Override
    public List<Exchange> findByCreatedAtBetween(Timestamp start, Timestamp end) {
        return repository.findByCreatedAtBetween(start, end);
    }

    @Override
    public Exchange save(Exchange Exchange) {
        return repository.save(Exchange);
    }

    @Override
    public List<Exchange> saveAll(List<Exchange> exchanges, Currency currency) {
        List<Exchange> result = new ArrayList<>();

        for (Exchange savingExchange: exchanges) {
            savingExchange.setCurrencyId(currency.getId());
            Exchange exchange = repository.save(savingExchange);
            result.add(exchange);
        }

        return result;
    }
}
