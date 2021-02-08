package com.stock.history.maintainhistory.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StockPriceId implements Serializable {
    private String stockCode;
    private Date timestamp;
}
