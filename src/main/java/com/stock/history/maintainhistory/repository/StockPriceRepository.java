package com.stock.history.maintainhistory.repository;

import com.stock.history.maintainhistory.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
