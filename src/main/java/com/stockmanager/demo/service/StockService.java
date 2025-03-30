package com.stockmanager.demo.service;

import com.stockmanager.demo.exception.InvalidSymbolNameException;
import com.stockmanager.demo.exception.InvalidTrendingTickerException;
import com.stockmanager.demo.model.Financials;
import com.stockmanager.demo.model.History;
import com.stockmanager.demo.model.Stock;
import com.stockmanager.demo.model.TrendingTicker;
import com.stockmanager.demo.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
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

    public List<History> getStockHistory(String symbol, String period1, String period2) throws IOException {
        if (period1 != null && period2 != null)
            return stockRepository.getHistory(symbol, period1, period2);
        return stockRepository.getHistory(symbol);
    }

    public Financials getFinancials(String symbol) throws IOException, InvalidSymbolNameException, NoSuchFieldException, IllegalAccessException {
        return stockRepository.getFinancials(symbol);
    }
}
