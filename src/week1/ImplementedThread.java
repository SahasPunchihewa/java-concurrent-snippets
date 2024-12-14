package week1;

import java.lang.Runnable;

public class ImplementedThread implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i <= 25; i++)
        {
            System.out.println(Thread.currentThread().getName() + ": " + i);

            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}