package space.aow.java.currencies.storage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import space.aow.java.currencies.storage.entities.Exchange;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ExchangeRepository extends CrudRepository<Exchange, Long> {
    List<Exchange> findByCreatedAtBetween(@Param("start") Timestamp start, @Param("end") Timestamp end);
    Optional<Exchange> findById(@Param("id") Long id);
}