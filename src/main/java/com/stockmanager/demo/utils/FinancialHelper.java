package com.stockmanager.demo.utils;

import com.stockmanager.demo.exception.InvalidSymbolNameException;
import com.stockmanager.demo.model.Financials;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class FinancialHelper {
    @Value("${app.stock.url}")
    private String stockUrl;
    @Value("${app.financials.url}")
    private String financialUrl;
    @Value("${error.invalidSymbol}")
    private String invalidSymbolErrMsg;

    @Autowired
    private NumHelper numHelper;

    public String getInstanceFieldName(String label) {
        if (label.isBlank()) return "";
        String[] words = label.trim().split("\\s+");
        StringBuilder capitalizedString = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedString.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());
            }
        }
        return (Character.toLowerCase(capitalizedString.toString().charAt(0)) + capitalizedString.substring(1))
                .replace("&", "And");
    }

    public String constructUrl(String symbol) throws InvalidSymbolNameException {
        if (symbol.isBlank())
            throw new InvalidSymbolNameException(invalidSymbolErrMsg);
        return stockUrl.concat(symbol).concat(financialUrl);
    }

    public Financials parseFinancials(Document document) throws InvalidSymbolNameException, NoSuchFieldException, IllegalAccessException {
        if (document.selectFirst("div.noData.yf-wnifss") != null)
            throw new InvalidSymbolNameException(invalidSymbolErrMsg);
        Elements containers = document.select("div.tableBody.yf-9ft13 div.row.lv-0.yf-t22klz");
        Financials financials = new Financials();
        for (Element row : containers) {
            String label = getInstanceFieldName(row.selectFirst("div.column.sticky.yf-t22klz").text());
            Elements values = row.select("div.column.yf-t22klz");
            Field field = Financials.class.getDeclaredField(label);
            field.setAccessible(true);
            for (Element value : values) {
                // div.sticky == label
                if (!value.className().contains("sticky")) {
                    if (field.get(financials) == null)
                        field.set(financials, new ArrayList<>());
                    List<Double> currentValue = (List<Double>) field.get(financials);
                    currentValue.add(numHelper.stringToNum(value.text()));
                    field.set(financials, currentValue);
                }
            }
        }
        return financials;
    }
}
