CREATE TABLE IF NOT EXISTS exchanges (
     id serial,
     amount float,
     currency_id int,
     created_at timestamp,
     PRIMARY KEY (id),
     FOREIGN KEY (currency_id) REFERENCES currencies
);