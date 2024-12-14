package week7.wifeHusband;

public class Husband implements Runnable
{
    private BankAccount bankAccount;

    public Husband(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            bankAccount.withdraw(1000.00);
            System.out.println(Thread.currentThread().getName() + " " + i + " " + 1000 + " : " + bankAccount.getBalance());
        }
    }
}