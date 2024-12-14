package week5;

public class Alphabet implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 65; i <= 90; i++)
        {
            System.out.println(Thread.currentThread() + ": " + (char)i);

            try {
                Thread.sleep(i*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}