package week7.wifeHusband;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount("NSB", 1000.00);

        Thread husbandThread = new Thread(new Husband(bankAccount), "Husband");
        Thread wifeThread = new Thread(new Wife(bankAccount), "Wife");

        System.out.println(husbandThread.getName() + " : " + husbandThread.getState());
        System.out.println(wifeThread.getName() + " : " + wifeThread.getState());

        husbandThread.start();
        wifeThread.start();

        System.out.println(husbandThread.getName() + " : " + husbandThread.getState());
        System.out.println(wifeThread.getName() + " : " + wifeThread.getState());

        try
        {
            husbandThread.join();
            wifeThread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted: " + e.getMessage());
        }
    }
}