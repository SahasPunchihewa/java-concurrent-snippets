package week1;

import java.lang.Thread;

public class ExtendedThread extends Thread
{
    public ExtendedThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for (int i = 0; i <= 25; i++)
        {
            System.out.println(Thread.currentThread().getName() + ": " + i);

            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}