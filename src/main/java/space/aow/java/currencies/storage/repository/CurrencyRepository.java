package space.aow.java.currencies.storage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import space.aow.java.currencies.storage.entities.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    List<Currency> findAll();
    Optional<Currency> findById(@Param("id") Long id);
    Optional<Currency> findByCode(@Param("code") String code);
}