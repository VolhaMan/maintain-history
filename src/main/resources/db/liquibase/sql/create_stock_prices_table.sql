    CREATE TABLE stock_prices (
        stock_code varchar(8) NOT NULL,
        timestamp datetime NOT NULL,
        price double precision NOT NULL,
        PRIMARY KEY (stock_code, timestamp),
        FOREIGN KEY (stock_code) REFERENCES stock(stock_code));
    COMMIT;

