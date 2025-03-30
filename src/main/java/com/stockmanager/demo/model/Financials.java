package com.stockmanager.demo.model;

import java.util.List;

public class Financials {
    private List<Double> totalRevenue;
    private List<Double> costOfRevenue;
    private List<Double> grossProfit;
    private List<Double> operatingIncome;
    private List<Double> operatingExpense;
    private List<Double> netNonOperatingInterestIncomeExpense;
    private List<Double> otherIncomeExpense;
    private List<Double> pretaxIncome;
    private List<Double> taxProvision;
    private List<Double> netIncomeCommonStockholders;
    private List<Double> dilutedNiAvailableToComStockholders;
    private List<Double> basicEps;
    private List<Double> dilutedEps;
    private List<Double> basicAverageShares;
    private List<Double> dilutedAverageShares;
    private List<Double> totalOperatingIncomeAsReported;
    private List<Double> totalExpenses;
    private List<Double> netIncomeFromContinuingAndDiscontinuedOperation;
    private List<Double> normalizedIncome;
    private List<Double> interestIncome;
    private List<Double> interestExpense;
    private List<Double> netInterestIncome;
    private List<Double> ebit;
    private List<Double> ebitda;
    private List<Double> reconciledCostOfRevenue;
    private List<Double> reconciledDepreciation;
    private List<Double> netIncomeFromContinuingOperationNetMinorityInterest;
    private List<Double> totalUnusualItemsExcludingGoodwill;
    private List<Double> totalUnusualItems;
    private List<Double> normalizedEbitda;
    private List<Double> taxRateForCalcs;
    private List<Double> taxEffectOfUnusualItems;

    public Financials(){}

    public Financials(List<Double> totalRevenue,
                      List<Double> costOfRevenue,
                      List<Double> grossProfit,
                      List<Double> operatingIncome,
                      List<Double> operatingExpense,
                      List<Double> netNonOperatingInterestIncomeExpense,
                      List<Double> otherIncomeExpense,
                      List<Double> pretaxIncome,
                      List<Double> taxProvision,
                      List<Double> netIncomeCommonStockholders,
                      List<Double> dilutedNiAvailableToComStockholders,
                      List<Double> basicEps,
                      List<Double> dilutedEps,
                      List<Double> basicAverageShares,
                      List<Double> dilutedAverageShares,
                      List<Double> totalOperatingIncomeAsReported,
                      List<Double> totalExpenses,
                      List<Double> netIncomeFromContinuingAndDiscontinuedOperation,
                      List<Double> normalizedIncome,
                      List<Double> interestIncome,
                      List<Double> interestExpense,
                      List<Double> netInterestIncome,
                      List<Double> ebit,
                      List<Double> ebitda,
                      List<Double> reconciledCostOfRevenue,
                      List<Double> reconciledDepreciation,
                      List<Double> netIncomeFromContinuingOperationNetMinorityInterest,
                      List<Double> totalUnusualItemsExcludingGoodwill,
                      List<Double> totalUnusualItems,
                      List<Double> normalizedEBITDA,
                      List<Double> taxRateForCalcs,
                      List<Double> taxEffectOfUnusualItems) {
        this.totalRevenue = totalRevenue;
        this.costOfRevenue = costOfRevenue;
        this.grossProfit = grossProfit;
        this.operatingIncome = operatingIncome;
        this.operatingExpense = operatingExpense;
        this.netNonOperatingInterestIncomeExpense = netNonOperatingInterestIncomeExpense;
        this.otherIncomeExpense = otherIncomeExpense;
        this.pretaxIncome = pretaxIncome;
        this.taxProvision = taxProvision;
        this.netIncomeCommonStockholders = netIncomeCommonStockholders;
        this.dilutedNiAvailableToComStockholders = dilutedNiAvailableToComStockholders;
        this.basicEps = basicEps;
        this.dilutedEps = dilutedEps;
        this.basicAverageShares = basicAverageShares;
        this.dilutedAverageShares = dilutedAverageShares;
        this.totalOperatingIncomeAsReported = totalOperatingIncomeAsReported;
        this.totalExpenses = totalExpenses;
        this.netIncomeFromContinuingAndDiscontinuedOperation = netIncomeFromContinuingAndDiscontinuedOperation;
        this.normalizedIncome = normalizedIncome;
        this.interestIncome = interestIncome;
        this.interestExpense = interestExpense;
        this.netInterestIncome = netInterestIncome;
        this.ebit = ebit;
        this.ebitda = ebitda;
        this.reconciledCostOfRevenue = reconciledCostOfRevenue;
        this.reconciledDepreciation = reconciledDepreciation;
        this.netIncomeFromContinuingOperationNetMinorityInterest = netIncomeFromContinuingOperationNetMinorityInterest;
        this.totalUnusualItemsExcludingGoodwill = totalUnusualItemsExcludingGoodwill;
        this.totalUnusualItems = totalUnusualItems;
        this.normalizedEbitda = normalizedEBITDA;
        this.taxRateForCalcs = taxRateForCalcs;
        this.taxEffectOfUnusualItems = taxEffectOfUnusualItems;
    }

    public void setTotalRevenue(List<Double> totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void setCostOfRevenue(List<Double> costOfRevenue) {
        this.costOfRevenue = costOfRevenue;
    }

    public void setGrossProfit(List<Double> grossProfit) {
        this.grossProfit = grossProfit;
    }

    public void setOperatingIncome(List<Double> operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public void setOperatingExpense(List<Double> operatingExpense) {
        this.operatingExpense = operatingExpense;
    }

    public void setNetNonOperatingInterestIncomeExpense(List<Double> netNonOperatingInterestIncomeExpense) {
        this.netNonOperatingInterestIncomeExpense = netNonOperatingInterestIncomeExpense;
    }

    public void setOtherIncomeExpense(List<Double> otherIncomeExpense) {
        this.otherIncomeExpense = otherIncomeExpense;
    }

    public void setPretaxIncome(List<Double> pretaxIncome) {
        this.pretaxIncome = pretaxIncome;
    }

    public void setTaxProvision(List<Double> taxProvision) {
        this.taxProvision = taxProvision;
    }

    public void setNetIncomeCommonStockholders(List<Double> netIncomeCommonStockholders) {
        this.netIncomeCommonStockholders = netIncomeCommonStockholders;
    }

    public void setDilutedNiAvailableToComStockholders(List<Double> dilutedNiAvailableToComStockholders) {
        this.dilutedNiAvailableToComStockholders = dilutedNiAvailableToComStockholders;
    }

    public void setBasicEps(List<Double> basicEps) {
        this.basicEps = basicEps;
    }

    public void setDilutedEps(List<Double> dilutedEps) {
        this.dilutedEps = dilutedEps;
    }

    public void setBasicAverageShares(List<Double> basicAverageShares) {
        this.basicAverageShares = basicAverageShares;
    }

    public void setDilutedAverageShares(List<Double> dilutedAverageShares) {
        this.dilutedAverageShares = dilutedAverageShares;
    }

    public void setTotalOperatingIncomeAsReported(List<Double> totalOperatingIncomeAsReported) {
        this.totalOperatingIncomeAsReported = totalOperatingIncomeAsReported;
    }

    public void setTotalExpenses(List<Double> totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public void setNetIncomeFromContinuingAndDiscontinuedOperation(List<Double> netIncomeFromContinuingAndDiscontinuedOperation) {
        this.netIncomeFromContinuingAndDiscontinuedOperation = netIncomeFromContinuingAndDiscontinuedOperation;
    }

    public void setNormalizedIncome(List<Double> normalizedIncome) {
        this.normalizedIncome = normalizedIncome;
    }

    public void setInterestIncome(List<Double> interestIncome) {
        this.interestIncome = interestIncome;
    }

    public void setInterestExpense(List<Double> interestExpense) {
        this.interestExpense = interestExpense;
    }

    public void setNetInterestIncome(List<Double> netInterestIncome) {
        this.netInterestIncome = netInterestIncome;
    }

    public void setEbit(List<Double> ebit) {
        this.ebit = ebit;
    }

    public void setEbitda(List<Double> ebitda) {
        this.ebitda = ebitda;
    }

    public void setReconciledCostOfRevenue(List<Double> reconciledCostOfRevenue) {
        this.reconciledCostOfRevenue = reconciledCostOfRevenue;
    }

    public void setReconciledDepreciation(List<Double> reconciledDepreciation) {
        this.reconciledDepreciation = reconciledDepreciation;
    }

    public void setNetIncomeFromContinuingOperationNetMinorityInterest(List<Double> netIncomeFromContinuingOperationNetMinorityInterest) {
        this.netIncomeFromContinuingOperationNetMinorityInterest = netIncomeFromContinuingOperationNetMinorityInterest;
    }

    public void setTotalUnusualItemsExcludingGoodwill(List<Double> totalUnusualItemsExcludingGoodwill) {
        this.totalUnusualItemsExcludingGoodwill = totalUnusualItemsExcludingGoodwill;
    }

    public void setTotalUnusualItems(List<Double> totalUnusualItems) {
        this.totalUnusualItems = totalUnusualItems;
    }

    public void setNormalizedEbitda(List<Double> normalizedEbitda) {
        this.normalizedEbitda = normalizedEbitda;
    }

    public void setTaxRateForCalcs(List<Double> taxRateForCalcs) {
        this.taxRateForCalcs = taxRateForCalcs;
    }

    public void setTaxEffectOfUnusualItems(List<Double> taxEffectOfUnusualItems) {
        this.taxEffectOfUnusualItems = taxEffectOfUnusualItems;
    }

    public List<Double> getTotalRevenue() {
        return totalRevenue;
    }

    public List<Double> getCostOfRevenue() {
        return costOfRevenue;
    }

    public List<Double> getGrossProfit() {
        return grossProfit;
    }

    public List<Double> getOperatingIncome() {
        return operatingIncome;
    }

    public List<Double> getOperatingExpense() {
        return operatingExpense;
    }

    public List<Double> getNetNonOperatingInterestIncomeExpense() {
        return netNonOperatingInterestIncomeExpense;
    }

    public List<Double> getOtherIncomeExpense() {
        return otherIncomeExpense;
    }

    public List<Double> getPretaxIncome() {
        return pretaxIncome;
    }

    public List<Double> getTaxProvision() {
        return taxProvision;
    }

    public List<Double> getNetIncomeCommonStockholders() {
        return netIncomeCommonStockholders;
    }

    public List<Double> getDilutedNiAvailableToComStockholders() {
        return dilutedNiAvailableToComStockholders;
    }

    public List<Double> getBasicEps() {
        return basicEps;
    }

    public List<Double> getDilutedEps() {
        return dilutedEps;
    }

    public List<Double> getBasicAverageShares() {
        return basicAverageShares;
    }

    public List<Double> getDilutedAverageShares() {
        return dilutedAverageShares;
    }

    public List<Double> getTotalOperatingIncomeAsReported() {
        return totalOperatingIncomeAsReported;
    }

    public List<Double> getTotalExpenses() {
        return totalExpenses;
    }

    public List<Double> getNetIncomeFromContinuingAndDiscontinuedOperation() {
        return netIncomeFromContinuingAndDiscontinuedOperation;
    }

    public List<Double> getNormalizedIncome() {
        return normalizedIncome;
    }

    public List<Double> getInterestIncome() {
        return interestIncome;
    }

    public List<Double> getInterestExpense() {
        return interestExpense;
    }

    public List<Double> getNetInterestIncome() {
        return netInterestIncome;
    }

    public List<Double> getEbit() {
        return ebit;
    }

    public List<Double> getEbitda() {
        return ebitda;
    }

    public List<Double> getReconciledCostOfRevenue() {
        return reconciledCostOfRevenue;
    }

    public List<Double> getReconciledDepreciation() {
        return reconciledDepreciation;
    }

    public List<Double> getNetIncomeFromContinuingOperationNetMinorityInterest() {
        return netIncomeFromContinuingOperationNetMinorityInterest;
    }

    public List<Double> getTotalUnusualItemsExcludingGoodwill() {
        return totalUnusualItemsExcludingGoodwill;
    }

    public List<Double> getTotalUnusualItems() {
        return totalUnusualItems;
    }

    public List<Double> getNormalizedEbitda() {
        return normalizedEbitda;
    }

    public List<Double> getTaxRateForCalcs() {
        return taxRateForCalcs;
    }

    public List<Double> getTaxEffectOfUnusualItems() {
        return taxEffectOfUnusualItems;
    }
}