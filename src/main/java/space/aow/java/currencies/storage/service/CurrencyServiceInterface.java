package space.aow.java.currencies.storage.service;

import org.springframework.stereotype.Service;
import space.aow.java.currencies.storage.entities.Currency;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public interface CurrencyServiceInterface {
    public List<Currency> findAll();
    List<Currency> findAllWithExchangesBetween(Timestamp start, Timestamp end);
    Optional<Currency> findByCode(String code);
    Currency save(Currency currency);
    List<Currency> saveAll(List<Currency> currencies);
}
