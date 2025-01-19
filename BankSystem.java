import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    // Method to initialize account details
    public void initialize(String customerName, int accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    // Method to withdraw money (to be overridden in subclasses)
    public void withdraw(double amount) {
        System.out.println("Withdrawal not implemented for this account type.");
    }
}

class Savn_Acct extends Account {
    private double interestRate = 0.05; // 5% annual interest rate

    // Method to compute and deposit interest
    public void computeAndDepositInterest(int years) {
        if (years > 0) {
            double interest = balance * Math.pow((1 + interestRate), years) - balance;
            balance += interest;
            System.out.println("Interest of Rs." + interest + " deposited for " + years + " year(s).\n");
        } else {
            System.out.println("Invalid number of years!");
        }
    }

    // Overriding the withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }
}

class Curr_Acct extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double PENALTY = 100.0;

    // Method to check minimum balance and impose penalty
    public void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Balance below minimum. Penalty of Rs." + PENALTY + " imposed.");
        }
    }

    // Overriding the withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Savings Account
        Savn_Acct savingsAccount = new Savn_Acct();
        savingsAccount.initialize("Alice", 12345, "Savings");
        savingsAccount.deposit(5000);
        savingsAccount.displayBalance();
        savingsAccount.computeAndDepositInterest(2);
        savingsAccount.displayBalance();
        savingsAccount.withdraw(2000);
        savingsAccount.displayBalance();

        System.out.println("--------------------");

        // Create Current Account
        Curr_Acct currentAccount = new Curr_Acct();
        currentAccount.initialize("Bob", 67890, "Current");
        currentAccount.deposit(1500);
        currentAccount.displayBalance();
        currentAccount.withdraw(600);
        currentAccount.displayBalance();
        currentAccount.withdraw(1000);
        currentAccount.displayBalance();

        scanner.close();
    }
}
