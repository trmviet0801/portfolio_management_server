package com.stockmanager.demo.controller;

import com.stockmanager.demo.exception.InvalidTrendingTickerException;
import com.stockmanager.demo.model.History;
import com.stockmanager.demo.model.Stock;
import com.stockmanager.demo.model.TrendingTicker;
import com.stockmanager.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("trending")
    public List<TrendingTicker> getStock() throws IOException, InvalidTrendingTickerException {
        return stockService.getTrendingTikers();
    }

    @GetMapping("gainers")
    public List<Stock> getTopGainers() throws IOException {
        return stockService.getTopGainers();
    }

    @GetMapping("stock/{symbol}")
    public Stock getStock(@PathVariable String symbol) throws IOException {
        return stockService.getStock(symbol);
    }

    @GetMapping("stock/{symbol}/history")
    public List<History> getStockHistory(@PathVariable String symbol,
                                         @RequestParam(name = "period1", required = false) String period1,
                                         @RequestParam(name = "period2", required = false) String period2) throws IOException {
        return stockService.getStockHistory(symbol, period1, period2);
    }
}
