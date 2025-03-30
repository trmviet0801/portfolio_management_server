package com.stockmanager.demo.utils;

import com.stockmanager.demo.model.History;
import com.stockmanager.demo.model.Stock;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockHelper {
    @Value("${app.stock.url}")
    private String stockUrl;

    private Stock elementToStock(Element symbol, Element name, Elements statistic, Element pe) {
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

    public List<Stock> convertDocumentToStocks(Elements elements) {
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

    public String stockUrlConstruct(String symbol) {
        return stockUrl + symbol;
    }

    public String stockUrlConstruct(String symbol, String period1, String period2) {
        if (period1 != null && period2 != null)
            return stockUrlConstruct(symbol) + "/history/?period1=" + period1 + "&period2=" + period2;
        return stockUrlConstruct(symbol) + "/history";
    }

    public Stock parseDetailStock(Document document) {
        Stock stock = new Stock();
        Elements lis = document.select("div.container.yf-1jj98ts li.yf-1jj98ts");
        Element price = document.select(".base.yf-ipw1h0").get(2);
        Elements changes = document.select(".base.txt-negative.yf-ipw1h0");
        Element name = document.selectFirst(".yf-xxbei9");
        Element description = document.selectFirst(".description.yf-1ja4ll8");

        stock.setPrice(Double.parseDouble(price.text()));
        stock.setChange(Double.parseDouble(changes.get(1).text()));
        stock.setPercentChange(Double.parseDouble(changes.get(2).text()
                .replace("%", "")
                .replace("(", "")
                .replace(")", "")));
        stock.setName(parseNameAndSymbol(name.text()).get(0));
        stock.setSymbol(parseNameAndSymbol(name.text()).get(1));
        stock.setDescription(description.text());
        for (Element li : lis) {
            Element label = li.selectFirst("span.label.yf-1jj98ts");
            Element value = li.selectFirst("span.value.yf-1jj98ts");
            if (label.text().equalsIgnoreCase("Volume")) stock.setVolume(value.text());
            else if (label.text().equalsIgnoreCase("Market Cap (intraday)")) stock.setMarketCap(value.text());
            else if (label.text().equalsIgnoreCase("PE Ratio (TTM)")) stock.setPe(value.text());
        }
        return stock;
    }

    public List<String> parseNameAndSymbol(String stock) {
        StringBuffer name = new StringBuffer();
        StringBuffer symbol = new StringBuffer();
        boolean isSymbol = false;
        for (char ch : stock.toCharArray()) {
            if (ch == '(' || ch == ')') isSymbol = !isSymbol;
            else if (!isSymbol) name.append(ch);
            else symbol.append(ch);
        }
        return List.of(name.toString().trim(), symbol.toString());
    }

    public long convertStringToUnixTimeStamp(String time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(time, dateTimeFormatter);
        return localDateTime.atZone(ZoneId.of("UTC")).toEpochSecond();
    }

    public List<History> parseHistoryPrice(Document document) {
        Element tbody = document.selectFirst("tbody");
        Elements trs = tbody.select("tr.yf-1jecxey");
        List<History> history = new ArrayList<>();
        for (Element tr : trs) {
            if (tr.select("td.yf-1jecxey").size() > 2)
                history.add(parseTrToHistory(tr));
        }
        return history;
    }

    private History parseTrToHistory(Element tr) {
        History history = new History();
        Elements tds = tr.select("td.yf-1jecxey");
        history.setDate(tds.get(0).text());
        history.setOpen(Double.parseDouble(tds.get(1).text()));
        history.setHigh(Double.parseDouble(tds.get(2).text()));
        history.setLow(Double.parseDouble(tds.get(3).text()));
        history.setClose(Double.parseDouble(tds.get(4).text()));
        history.setVolume(tds.get(6).text());
        return history;
    }
}
