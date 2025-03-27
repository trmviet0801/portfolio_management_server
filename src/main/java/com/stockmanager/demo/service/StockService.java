package com.stockmanager.demo.service;

import com.stockmanager.demo.exception.InvalidTrendingTickerException;
import com.stockmanager.demo.model.Stock;
import com.stockmanager.demo.model.TrendingTicker;
import com.stockmanager.demo.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public StockService(){}

    public List<TrendingTicker> getTrendingTikers() throws IOException, InvalidTrendingTickerException {
        return stockRepository.getTrendingTickers();
    }

    public List<Stock> getTopGainers() throws IOException {
        return stockRepository.getTopGainers();
    }

    public Stock getStock(String symbol) throws IOException {
        return stockRepository.getStock(symbol);
    }
}
