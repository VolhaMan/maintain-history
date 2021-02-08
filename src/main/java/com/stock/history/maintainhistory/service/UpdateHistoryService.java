package com.stock.history.maintainhistory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.history.maintainhistory.model.Stock;
import com.stock.history.maintainhistory.model.StockPrice;
import com.stock.history.maintainhistory.repository.StockPriceRepository;
import com.stock.history.maintainhistory.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class UpdateHistoryService {
    @Autowired
    StockPriceRepository stockPriceRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ObjectMapper objectMapper;
    @Value("${stock.price.url}")
    private String url;

    public void updateHistory() throws JsonProcessingException {
        List<Stock> stocks = stockRepository.findAll();
        for (Stock stock : stocks) {
            Mono<StockPrice> stockPriceMono = getCurrentStockPrice(stock.getStockCode());
            stockPriceMono.subscribe(stockPriceRepository::save);
            stockPriceMono.subscribe((StockPrice stockPrice) -> log.info("Price {} gathered for the stock code {}", stockPrice.getPrice(), stockPrice.getStockCode()));
        }
    }

    public Mono<StockPrice> getCurrentStockPrice(String stockCode) throws JsonProcessingException {
        WebClient webClient = WebClient.builder().baseUrl(url).build();
        return webClient.get().uri(uriBuilder -> uriBuilder.queryParam("stock_code", stockCode).build()).retrieve().bodyToMono(StockPrice.class);
    }
}
