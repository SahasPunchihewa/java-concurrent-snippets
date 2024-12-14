package week7.wifeHusband;

public class Wife implements Runnable
{
    private BankAccount bankAccount;

    public Wife(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            bankAccount.deposit(1000.00);
            System.out.println(Thread.currentThread().getName() + " " + i + " " + 1000 + " : " + bankAccount.getBalance());
        }
    }
}