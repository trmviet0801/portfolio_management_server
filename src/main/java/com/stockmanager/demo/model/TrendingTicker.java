package com.stockmanager.demo.model;

public class TrendingTicker {
    private String symbol;
    private String name;
    private double lastPrice;
    private double change;
    private double percentChange;

    public TrendingTicker() {}

    public TrendingTicker(String symbol, String name, double lastPrice, double change, double percentChange) {
        this.symbol = symbol;
        this.name = name;
        this.lastPrice = lastPrice;
        this.change = change;
        this.percentChange = percentChange;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public double getChange() {
        return change;
    }

    public double getPercentChange() {
        return percentChange;
    }
}
