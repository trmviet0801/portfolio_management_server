package com.stockmanager.demo.model;

public class Stock {
    private String name;
    private String symbol;
    private String marketCap;
    private String description;
    private double price;
    private double change;
    private double percentChange;
    private String volume;
    private String pe;


    public Stock() {
    }

    public Stock(String name, String symbol, String marketCap,
                 String description, double price, double change,
                 double percentChange, String volume, String pe) {
        this.name = name;
        this.symbol = symbol;
        this.marketCap = marketCap;
        this.description = description;
        this.price = price;
        this.change = change;
        this.percentChange = percentChange;
        this.volume = volume;
        this.pe = pe;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", marketCap=" + marketCap +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", change=" + change +
                ", percentChange=" + percentChange +
                ", volume=" + volume +
                ", pe=" + pe +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getChange() {
        return change;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public String getVolume() {
        return volume;
    }

    public String getPe() {
        return pe;
    }
}
