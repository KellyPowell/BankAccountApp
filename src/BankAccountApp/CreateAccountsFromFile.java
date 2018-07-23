package BankAccountApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// read a CSV File then create new accounts based on that data

class CreateAccountsFromFile {


    ArrayList<Account> createAccountsBatch() {

        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            File file = new File("/Users/kelly.powell/Downloads/Bank_Application/NewBankAccounts.csv");
            Scanner scanner = new Scanner(file);
            label:
            while (scanner.hasNextLine()) {
                String readLine = scanner.nextLine();
                String[] splitLine = readLine.split(",");
                String name = splitLine[0];
                String sSN = splitLine[1];
                String accountType = splitLine[2];
                Double initDeposit = Double.parseDouble(splitLine[3]);

                switch (accountType) {
                    case "BankAccountApp.Savings":
                        Savings newSavings = new Savings(name, sSN, initDeposit);
                        newSavings.showInfo();
                        accounts.add(newSavings);

                        break;
                    case "BankAccountApp.Checking":
                        Checking newChecking = new Checking(name, sSN, initDeposit);
                        newChecking.showInfo();
                        accounts.add(newChecking);

                        break;
                    default:
                        System.out.println("Incorrect field for account type! Please check file.");
                        break label;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return accounts;
    }

}