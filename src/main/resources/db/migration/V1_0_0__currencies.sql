CREATE TABLE IF NOT EXISTS currencies (
    id serial,
    code varchar(5),
    name varchar(60),
    PRIMARY KEY (id)
);