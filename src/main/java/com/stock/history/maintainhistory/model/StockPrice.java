package com.stock.history.maintainhistory.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "stock_prices")
@IdClass(StockPriceId.class)
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice implements Serializable {
    @Id
    @Column(name = "stock_code")
    String stockCode;
    @Id
    @Column(name = "timestamp")
    Date timestamp;
    @Column(name = "price")
    double price;
}
