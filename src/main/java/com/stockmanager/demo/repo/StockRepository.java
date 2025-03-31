package com.stockmanager.demo.repo;

import com.stockmanager.demo.exception.InvalidSymbolNameException;
import com.stockmanager.demo.exception.InvalidTrendingTickerException;
import com.stockmanager.demo.model.*;
import com.stockmanager.demo.utils.FinancialHelper;
import com.stockmanager.demo.utils.NewsHelper;
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
    @Autowired
    private FinancialHelper financialHelper;
    @Autowired
    private NewsHelper newsHelper;

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

    public List<History> getHistory(String symbol, String period1, String period2) throws IOException {
        Document document = getDocument(stockHelper.stockUrlConstruct(symbol, period1, period2));
        return stockHelper.parseHistoryPrice(document);
    }

    public List<History> getHistory(String symbol) throws IOException{
        Document document = getDocument(stockHelper.stockUrlConstruct(symbol, null, null));
        return stockHelper.parseHistoryPrice(document);
    }

    public Financials getFinancials(String symbol) throws IOException, InvalidSymbolNameException, NoSuchFieldException, IllegalAccessException {
        Document document = getDocument(financialHelper.constructUrl(symbol));
        return financialHelper.parseFinancials(document);
    }

    public List<News> getNews(String symbol) throws InvalidSymbolNameException, IOException {
        Document document = getDocument(newsHelper.constructUrl(symbol));
        return newsHelper.parseNews(document);
    }
}
