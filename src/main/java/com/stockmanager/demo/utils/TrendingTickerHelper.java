package com.stockmanager.demo.utils;

import com.stockmanager.demo.exception.InvalidTrendingTickerException;
import com.stockmanager.demo.model.TrendingTicker;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TrendingTickerHelper {
    public static List<TrendingTicker> convertRawDataIntoTicker(Elements tickers) throws InvalidTrendingTickerException {
        List<TrendingTicker> result = new ArrayList<>();
        for (Element ticker : tickers) {
            Element symbol = ticker.selectFirst(".loud-link.fin-size-medium.ellipsis.yf-1xqzjha");
            Element name = ticker.selectFirst(".yf-362rys");
            Elements changes = ticker.select("fin-streamer");
            if (symbol == null || name == null || changes.size() < 3)
                throw new InvalidTrendingTickerException("Data from web is null");
            result.add(createTrendingTickerFromElements(symbol, name, changes));
        }
        return result;
    }

    private static TrendingTicker createTrendingTickerFromElements(
            Element symbol, Element name, Elements changes
    ) {
        TrendingTicker trendingTicker = new TrendingTicker();
        trendingTicker.setName(name.text());
        trendingTicker.setSymbol(symbol.text());
        trendingTicker.setLastPrice(Double.parseDouble(changes.get(0).attr("data-value")));
        trendingTicker.setChange(Double.parseDouble(changes.get(1).attr("data-value")));
        trendingTicker.setPercentChange(Double.parseDouble(changes.get(2).attr("data-value")));
        return trendingTicker;
    }
}
