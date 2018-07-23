package BankAccountApp;

public interface IRate {

    default double getBaseRate() {
        return 1.19;
    }
}
