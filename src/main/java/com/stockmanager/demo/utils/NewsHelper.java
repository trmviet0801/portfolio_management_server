package com.stockmanager.demo.utils;

import com.stockmanager.demo.exception.InvalidSymbolNameException;
import com.stockmanager.demo.model.News;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsHelper {
    @Value("${app.stock.url}")
    private String stockUrl;
    @Value("${app.news.url}")
    private String newsUrl;
    @Value("${error.invalidSymbol}")
    private String invalidSymbolErrMsg;

    public String constructUrl(String symbol) throws InvalidSymbolNameException{
        if (symbol.isBlank())
            throw new InvalidSymbolNameException(invalidSymbolErrMsg);
        return stockUrl + symbol + newsUrl;
    }

    public List<News> parseNews(Document document) throws InvalidSymbolNameException {
        if (document.selectFirst("div.noData.yf-wnifss") != null)
            throw new InvalidSymbolNameException(invalidSymbolErrMsg);
        Elements container = document.select("ul.stream-items.yf-1usaaz9 li.stream-item.story-item.yf-1usaaz9");
        List<News> response = new ArrayList<>();
        for (Element row : container) {
            // li.ad-item == ad-post
            if (!row.className().contains("ad-item")) {
                Element link = row.selectFirst("a.subtle-link.fin-size-small.titles.noUnderline.yf-1xqzjha");
                String imageUrl = row.selectFirst("a.subtle-link.fin-size-small.thumb.yf-1xqzjha img") != null
                        ? row.selectFirst("a.subtle-link.fin-size-small.thumb.yf-1xqzjha img").attr("src") : null;
                String description = link.selectFirst("p.clamp.yf-82qtw3").text();
                String title = link.attr("title");
                String url = link.attr("href");
                String[] publishing = row.selectFirst("div.publishing.yf-1weyqlp").text().split("•");
                News news = new News();
                news.setTitle(title);
                news.setDescription(description);
                news.setImageUrl(imageUrl);
                news.setUrl(url);
                news.setPublisher(publishing[0].trim());
                news.setTime(publishing[1].trim());
                response.add(news);
            }
        }
        return response;
    }
}
