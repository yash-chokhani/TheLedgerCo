package com.example.geektrustproblems;

public class BankBalance {

    private String name;

    private String bankName;

    private int amountPaid;

    private int emiRemaining;

    public BankBalance(String name, String bankName, int amountPaid, int emiRemaining) {
        this.name = name;
        this.bankName = bankName;
        this.amountPaid = amountPaid;
        this.emiRemaining = emiRemaining;
    }

    public BankBalance() {

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

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getEmiRemaining() {
        return emiRemaining;
    }

    public void setEmiRemaining(int emiRemaining) {
        this.emiRemaining = emiRemaining;
    }

    @Override
    public String toString() {
        return bankName  + " " + name + " " + amountPaid + " " + emiRemaining;
    }
}
