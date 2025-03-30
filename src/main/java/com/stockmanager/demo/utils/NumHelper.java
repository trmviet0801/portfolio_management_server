package com.stockmanager.demo.utils;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class NumHelper {
    public double stringToNum(String num) {
        if (num.equalsIgnoreCase("--") || num.isEmpty())
            return -1.0;
        if (num.length() == 1)
            return Double.parseDouble(num);
        num = num.replace(",", "").toUpperCase();
        double parsed = Double.parseDouble(num.substring(0, num.length() - 1));
        if (num.matches(".*B$"))
            return parsed * 1_000_000_000;
        else if (num.matches(".*M$"))
            return parsed * 1_000_000;
        return Double.parseDouble(num);
    }
}
