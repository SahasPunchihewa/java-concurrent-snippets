package week5;

public class Number extends Thread
{

    public Number(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for (int i = 0; i <= 25; i++)
        {
            System.out.println(this.getName() + ": " + i);

            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}