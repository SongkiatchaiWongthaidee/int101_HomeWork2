package work03;

import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null)
            throw new NullPointerException("Owner it null");
        
        this.owner = owner;
        this.balance = 0.0;
        long result = Utilitor.computeIsbn10(nextNo);
        while (result == 10) {
            nextNo++; // Increment nextNo until we get a result that is not 10
            result = Utilitor.computeIsbn10(nextNo);
        }
        
        this.no = 10 * nextNo + result;
        nextNo++;
        
    }

    public long getNo() { return no;}
    public Person getOwner() {return owner;}
    public double getBalance() {return balance;}

    public double deposit(double amount) {
        amount = Utilitor.testPositive(amount);
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        amount = Utilitor.testPositive(amount);
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        return balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null || this.withdraw(amount) < 0) {
            throw new IllegalArgumentException("Transfer failed");
        }
        account.deposit(amount);
    }

    @Override
    public String toString() {return "Account(" + no + "," + balance + ")";}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        return no == other.no;
    }
}
