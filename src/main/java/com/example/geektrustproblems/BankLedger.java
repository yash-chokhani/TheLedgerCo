package com.example.geektrustproblems;

import java.util.List;

public class BankLedger {

    private String name;

    private String bankName;

    private Double principalAmount;

    private int year;

    public BankLedger(String name, String bankName, Double principalAmount, int year, int interestRate, List<RePayment> rePaymentList) {
        this.name = name;
        this.bankName = bankName;
        this.principalAmount = principalAmount;
        this.year = year;
        this.interestRate = interestRate;
        this.rePaymentList = rePaymentList;
    }

    private int interestRate;

    public BankLedger() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public List<RePayment> getRePaymentList() {
        return rePaymentList;
    }

    public void setRePaymentList(List<RePayment> rePaymentList) {
        this.rePaymentList = rePaymentList;
    }

    private List<RePayment> rePaymentList;

}
