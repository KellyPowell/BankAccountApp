package BankAccountApp;

import java.util.concurrent.ThreadLocalRandom;

public class Savings extends Account {

    // list properties specific to Savings account
    private String safetyDepositBoxID;
    private String safetyDepositBoxKey;


    // Constructor to initialize settings for the Savings properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        this.safetyDepositBoxKey = setSafetyDepositBoxKey();
        this.safetyDepositBoxID = setSafetyDepositBoxID();

        this.rate = setRate();

    }

    @Override
    public double setRate() {
        rate = (getBaseRate() - .25);
        return rate;

    }

    // The ShowInfo method should reveal relevant account info as well as info specific to Checking or Savings account
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Savings");
        System.out.println("SAFETY DEPOSIT BOX # " + safetyDepositBoxID);
        System.out.println("BOX CODE: " + safetyDepositBoxKey);
        System.out.println("RATE: " + rate + "%");
        System.out.println("***********************");
        System.out.println("");
    }

    // List any methods specific to savings account
    // Savings Account holders are given a safety deposit box, with 3 digit ID number, and 4 digit code

    private String setSafetyDepositBoxID() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 1000);
        safetyDepositBoxID = String.format("%03d", randomNumber);
        return safetyDepositBoxID;
    }

    private String setSafetyDepositBoxKey() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 10000);
        safetyDepositBoxKey = String.format("%04d", randomNumber);
        return safetyDepositBoxKey;
    }

}
