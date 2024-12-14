package week1;

public class Main
{
    public static void main(String[] args)
    {
        Thread extendedThread = new ExtendedThread("Extended Thread");

        Runnable implementedRunnable = new ImplementedThread();

        Thread implementedThread = new Thread(implementedRunnable, "Implemented Thread");

        Thread lambdaThread = new Thread(() ->
        {
            for (int i = 0; i <= 25; i++)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);

                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        });

        extendedThread.start();
        implementedThread.start();
        lambdaThread.start();

        try
        {
            extendedThread.join();
            implementedThread.join();
            lambdaThread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}