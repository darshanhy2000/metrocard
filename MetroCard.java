package metrocard;

public class MetroCard {
    private String cardNumber;
    private double balance;

    public MetroCard(String cardNumber, double initialBalance) {
        this.cardNumber = cardNumber;
        this.balance = initialBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void recharge(double amount) {
        this.balance += amount;
    }

    public boolean hasSufficientBalance(double amount) {
        return this.balance >= amount;
    }

    public void deduct(double amount) {
        this.balance -= amount;
    }
}

