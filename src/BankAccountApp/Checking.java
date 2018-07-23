package BankAccountApp;

import java.util.concurrent.ThreadLocalRandom;

public class Checking extends Account {

    // list properties specific to a checking account
    // debit card with pin, account number beginning with 2
    private long debitCardNumber;
    private int debitCardPIN;

    // Constructor to init checking acct properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        this.debitCardNumber = setDebitCardNumber();
        this.debitCardPIN = setDebitCardPIN();
        this.rate = setRate();
    }

    @Override
    public double setRate() {
        rate = (getBaseRate() * .15);   /// why is it rounding to 0???
        return rate;
    }

    // The ShowInfo method should reveal relevant account info as well as info specific to Checking or Savings account

    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Checking");
        System.out.println("DEBIT CARD #: " + debitCardNumber);
        System.out.println("PIN: " + debitCardPIN);
        System.out.println("RATE: " + rate + "%");
        System.out.println("***********************");
        System.out.println("");
    }

    // list any methods specific to the checking account

    // assigned a debit card, with 12 digit number, 4 digit pin

    /*
    private String setDebitCardNumber() {
        StringBuilder debitString = new StringBuilder();
        while (debitString.length() < 12) {
            Random rand = new Random();
            int n = rand.nextInt(10);
            debitString.append(n);
        }
        debitCardNumber = debitString.toString();
        return debitCardNumber;

    }
    */

    private long setDebitCardNumber() {
        long debitCardNumber = (long) Math.floor(Math.random() * 900_000_000_000L) + 100_000_000_000L;  // this works, but will never return number starting with 0
        return debitCardNumber;
    }



    /*
    debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
    debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
     */

    private int setDebitCardPIN() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 10000);
        String randomNumberAsString = String.format("%04d", randomNumber);
        debitCardPIN = Integer.parseInt(randomNumberAsString);
        return debitCardPIN;
    }


}
