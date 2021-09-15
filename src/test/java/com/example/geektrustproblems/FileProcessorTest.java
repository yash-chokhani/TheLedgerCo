package com.example.geektrustproblems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FileProcessorTest {

    Map<String, BankLedger> bankLedgerMap = new HashMap<>();
    List<BankBalance> bankBalanceList = new ArrayList<>();
    FileProcessor fileProcessor = new FileProcessor();

    @Test
    public void setBalance(){
        String command = "LOAN IDIDI Dale 10000 5 4";
        fileProcessor.processInputCommands(command, bankLedgerMap, bankBalanceList);
        assertTrue(bankLedgerMap.containsKey("Dale"));
    }

    @Test
    public void setRepayment(){
        String command = "LOAN IDIDI Dale 5000 1 6";
        fileProcessor.processInputCommands(command, bankLedgerMap, bankBalanceList);
        command = "PAYMENT IDIDI Dale 1000 5";
        fileProcessor.processInputCommands(command, bankLedgerMap, bankBalanceList);
        assertEquals(1, bankLedgerMap.get("Dale").getRePaymentList().size());
    }

    @Test
    public void getBalance(){
        String command = "LOAN IDIDI Dale 5000 1 6";
        fileProcessor.processInputCommands(command, bankLedgerMap, bankBalanceList);
        command = "PAYMENT IDIDI Dale 1000 5";
        fileProcessor.processInputCommands(command, bankLedgerMap, bankBalanceList);
        command="BALANCE IDIDI Dale 3";
        fileProcessor.processInputCommands(command, bankLedgerMap, bankBalanceList);
        assertEquals(9, bankBalanceList.get(0).getEmiRemaining());
    }

}