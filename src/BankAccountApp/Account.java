// we want an abstract class here, because we'll never create an Account object
// we'll be creating BankAccountApp.Checking and BankAccountApp.Savings objects (that extend Account)

package BankAccountApp;


import java.util.concurrent.ThreadLocalRandom;

public abstract class Account implements IRate {
    // list common properties for savings and checking account
    private String name;
    private String sSN;

    double initDeposit;
    private double balance;
    private static int index = 10000;  // base of account number, we will increment each time we create a new account
    double rate;
    String accountNumber;

    // Constructor to set base properties and initialize the account
    Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;
        //System.out.println("NAME: " + name + " SSN: " + sSN + " BALANCE: $" + balance);

        // set account number
        index++;
        this.accountNumber = setAccountNumber();
        //System.out.println("ACCOUNT NUMBER: " + this.accountNumber);


    }

    public abstract double setRate();

    private String setAccountNumber() {
        // 11-digit account number with the following properties:
        // 1 for Savings or 2 for checking, last two digits of SSN, unique 5 digit number, and random 3 digit number

        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 1000);
        String randomNumberAsString = String.format("%03d", randomNumber);  // otherwise, drops leading zeroes, giving 1 and 2 digit nums

        // (int) (Math.random() * 1000);  // to get random 3 digit number, but drops leading zeroes on 1 and 2 digit nums??
        accountNumber = lastTwoOfSSN + uniqueID + randomNumberAsString;
        return accountNumber;
    }

    // List common methods


    void deposit(double depositAmount) {
        balance = balance + depositAmount;
        System.out.println("Deposited $" + depositAmount);
        printBalance();

    }

    void withdrawal(double withdrawAmount) {
        if (withdrawAmount <= balance) {
            balance = balance - withdrawAmount;
            System.out.println("\n$" + withdrawAmount + " withdrawn");
            printBalance();

        } else {
            System.out.println("\nInsufficient balance for this withdrawal!");
            System.out.println("");
        }
    }


    void transfer(String toWhere, double transferAmount) {
        balance = balance = transferAmount;
        System.out.println("Transfering $" + transferAmount + " to " + toWhere);
        printBalance();
    }

    void printBalance() {
        System.out.println("Balance is now: $" + balance);
        System.out.println("");
    }

    public void showInfo() {
        System.out.println(
                "NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance);

    }




}
