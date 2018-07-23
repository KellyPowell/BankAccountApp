package BankAccountApp;

/*
Scenario: You are a backend developer and need to create an application to handle new customer bank account requests
Should do the following:
* Read a .csv file of names, ssn, account type, and initial deposit
* Use a proper data structure to hold all these accounts
* Both savings and checking accounts share the following properties:
    deposit()
    withdrawal()
    transfer()
    showInfo()
    11-digit account number with the following properties:
        1 or 2 for BankAccountApp.Savings/BankAccountApp.Checking, last two digits of SSN, unique 5 digit number, and random 3 digit number

BankAccountApp.Savings Account holders are given a safety deposit box, with 3 digit number, and 4 digit code
BankAccountApp.Checking Account holders are assigned a debit card, with 12 digit number, 4 digit pin
Both accounts use an interface that determines the base interest rate
    BankAccountApp.Savings account will use .25 points less than base rate
    BankAccountApp.Checking account will use 15% of the base rate

The ShowInfo method should reveal relevant account info as well as info specific to BankAccountApp.Checking or BankAccountApp.Savings account

 */


public class Main {
    public static void main(String[] args) {

        Checking chkacc1 = new Checking("Bob Wilson", "321445879", 1500);
        Savings save1 = new Savings("Tom Bodett", "234453678", 2200);

        chkacc1.showInfo();

        //chkacc1.withdrawal(15000);
        //chkacc1.withdrawal(150);
        save1.showInfo();
        //save1.deposit(600);
        //save1.withdrawal(400);

        CreateAccountsFromFile ca1 = new CreateAccountsFromFile();
        ca1.createAccountsBatch();





    }
}



