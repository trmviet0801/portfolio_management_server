package com.stockmanager.demo.utils;

import com.stockmanager.demo.model.Stock;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class StockHelper {
    private static Stock elementToStock(
            Element symbol,
            Element name,
            Elements statistic,
            Element pe
    ) {
        Stock stock = new Stock();
        stock.setSymbol(symbol.text());
        stock.setName(name.text());
        stock.setPrice(Double.parseDouble(statistic.get(0).attr("data-value")));
        stock.setChange(Double.parseDouble(statistic.get(1).attr("data-value")));
        stock.setPercentChange(Double.parseDouble(statistic.get(2).attr("data-value")));
        stock.setVolume(statistic.get(5).text());
        stock.setMarketCap(statistic.get(6).text());
        stock.setPe(pe.text());
        return stock;
    }

    public static List<Stock> convertDocumentToStocks(Elements elements) {
        List<Stock> stocks = new ArrayList<>();
        for (Element element : elements) {
            Element symbol = element.selectFirst(".ticker.small.tw-text-md.hover.noPadding.yf-1fqyif7");
            Element name = element.selectFirst(".yf-362rys");
            Elements statistic = element.select("fin-streamer");
            Element pe = element.selectFirst(".yf-hhhli1").select("span.yf-hhhli1").get(9);

            stocks.add(elementToStock(symbol, name, statistic, pe));
        }
        return stocks;
    }

}
