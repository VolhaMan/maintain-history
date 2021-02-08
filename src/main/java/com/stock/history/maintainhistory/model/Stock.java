package com.stock.history.maintainhistory.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="stock")
public class Stock {
    @Column(name="stock_code")
    @Id
    private String stockCode;
    @Column(name = "stock_name")
    private String stockName;
}
