package space.aow.java.currencies.storage.service;

import org.springframework.stereotype.Service;
import space.aow.java.currencies.storage.entities.Currency;
import space.aow.java.currencies.storage.entities.Exchange;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface ExchangeServiceInterface{
    List<Exchange> findByCreatedAtBetween(Timestamp start, Timestamp end);
    Exchange save(Exchange Exchange);
    List<Exchange> saveAll(List<Exchange> exchanges, Currency currency);
}
