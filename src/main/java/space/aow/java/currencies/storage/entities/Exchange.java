package space.aow.java.currencies.storage.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "exchanges")
public class Exchange {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "currency_id")
    private Long currencyId;
}
