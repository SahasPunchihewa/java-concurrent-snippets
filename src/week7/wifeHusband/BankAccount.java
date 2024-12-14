package week7.wifeHusband;

public class BankAccount
{
    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber, Double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(Double amount)
    {
        while (balance > 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }

        balance += amount;

        notifyAll();
    }

    public synchronized void withdraw(Double amount)
    {
        while (balance < amount)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }

        balance -= amount;

        notifyAll();
    }

    public Double getBalance()
    {
        return balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }
}