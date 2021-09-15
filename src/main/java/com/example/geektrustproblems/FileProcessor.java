package com.example.geektrustproblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

public class FileProcessor {

    public void processInputFile(File file) throws FileNotFoundException {
        Map<String, BankLedger> map = new HashMap<>();
        List<BankBalance> bankBalanceList = new ArrayList<>();
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String command = sc.nextLine();
                processInputCommands(command, map, bankBalanceList);
            }
        }
        for (BankBalance bankBalance: bankBalanceList){
            System.out.println(bankBalance.toString());
        }
    }

    private void processInputCommands(String command, Map<String, BankLedger> map, List<BankBalance> bankBalanceList) {
        String[] commandParams = command.split(" ");
        BankActions bankActions = BankActions.valueOf(commandParams[0]);
        switch (bankActions) {
            case LOAN:
                BankLedger bankLedger = setBankLedger(commandParams);
                map.put(commandParams[2],bankLedger);
                break;
            case PAYMENT:
                BankLedger bankLedger1 = map.get(commandParams[2]);
                map.put(commandParams[2],setRepayments(commandParams, bankLedger1));
                break;
            case BALANCE:
                BankLedger bankLedger2 = map.getOrDefault(commandParams[2],new BankLedger());
                bankBalanceList.add(getBankBalance(commandParams, bankLedger2));
                break;
        }
    }

    private BankLedger setBankLedger(String[] commandParams) {
        BankLedger bankLedger = new BankLedger();
        bankLedger.setBankName(commandParams[1]);
        bankLedger.setName(commandParams[2]);
        bankLedger.setPrincipalAmount(Double.parseDouble(commandParams[3]));
        bankLedger.setInterestRate(Integer.parseInt(commandParams[5]));
        bankLedger.setYear(Integer.parseInt(commandParams[4]));
        return bankLedger;
    }

    private BankLedger setRepayments(String[] commandParams, BankLedger bankLedger1) {
        RePayment rePayment = new RePayment();
        rePayment.setAmount(Double.parseDouble(commandParams[3]));
        rePayment.setEmiNumber(Integer.parseInt(commandParams[4]));
        List<RePayment> rePaymentList = new ArrayList<>();
        if (Objects.nonNull(bankLedger1.getRePaymentList())){
            rePaymentList = bankLedger1.getRePaymentList();
        }
        rePaymentList.add(rePayment);
        bankLedger1.setRePaymentList(rePaymentList);
        return bankLedger1;
    }

    private BankBalance getBankBalance(String[] commandParams, BankLedger bankLedger2) {
        BankBalance bankBalance = new BankBalance();
        bankBalance.setBankName(commandParams[1]);
        bankBalance.setName(commandParams[2]);
        int numberOfEMI = bankLedger2.getYear()*12;
        double principalAmount = bankLedger2.getPrincipalAmount();
        double emi = principalAmount/numberOfEMI;
        double interest = (principalAmount*bankLedger2.getInterestRate()/12/100);
        double amountEMI = Math.ceil(emi+interest);
        double amountPaid = 0;
        int emiNumber = Integer.parseInt(commandParams[3]);
        if (Objects.nonNull(bankLedger2.getRePaymentList())) {
            for (RePayment rePayment1 : bankLedger2.getRePaymentList()) {
                if (rePayment1.getEmiNumber() <= emiNumber) {
                    amountPaid += rePayment1.getAmount();
                }
            }
        }
        int emiGiven = (int) Math.floor(amountPaid/amountEMI);
        amountPaid+=amountEMI*emiNumber;
        int emiRemaining = numberOfEMI-emiGiven-emiNumber;
        bankBalance.setEmiRemaining(emiRemaining);
        bankBalance.setAmountPaid((int)amountPaid);
        return bankBalance;
    }

}
