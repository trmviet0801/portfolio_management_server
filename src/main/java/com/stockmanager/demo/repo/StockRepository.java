package com.stockmanager.demo.repo;

import com.stockmanager.demo.exception.InvalidTrendingTickerException;
import com.stockmanager.demo.model.Stock;
import com.stockmanager.demo.model.TrendingTicker;
import com.stockmanager.demo.utils.StockHelper;
import com.stockmanager.demo.utils.TrendingTickerHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StockRepository {
    @Value("${app.base.url}")
    private String baseUrl;
    @Value("${app.lookup.url}")
    private String lookupUrl;
    @Value("${app.gainers.url}")
    private String gainersUrl;

    @Autowired
    private StockHelper stockHelper;

    public List<TrendingTicker> getTrendingTickers() throws InvalidTrendingTickerException, IOException {
        Document document = getDocument(lookupUrl);
        Elements tickers = document.select(".row.false.yf-hhhli1");
        return TrendingTickerHelper.convertRawDataIntoTicker(tickers);
    }

    public List<Stock> getTopGainers() throws IOException {
        Document document = getDocument(gainersUrl);
        Elements gainers = document.select(".row.false.yf-hhhli1");
        return stockHelper.convertDocumentToStocks(gainers);
    }

    private Document getDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public Stock getStock(String symbol) throws IOException {
        Document document = getDocument(stockHelper.stockUrlConstruct(symbol));
        return document.selectFirst(".noData.yf-wnifss") != null ? new Stock()
                : stockHelper.parseDetailStock(document);
    }
}
