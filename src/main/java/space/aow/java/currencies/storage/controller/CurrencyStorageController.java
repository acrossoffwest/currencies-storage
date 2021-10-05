package space.aow.java.currencies.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.aow.java.currencies.storage.entities.Currency;
import space.aow.java.currencies.storage.service.CurrencyService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/currencies-storage")
public class CurrencyStorageController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/history/{start}/{end}")
    public List<Currency> currenciesExchangeHistory(@PathVariable String start, @PathVariable String end) {
        return currencyService.findAllWithExchangesBetween(Timestamp.valueOf(start), Timestamp.valueOf(end));
    }
}
