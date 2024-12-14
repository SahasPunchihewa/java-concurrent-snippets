package week7;

public class Mother implements Runnable
{
    private Plate plate;

    public Mother(Plate plate)
    {
        this.plate = plate;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            plate.serve("Food" + i);
            System.out.println(Thread.currentThread().getName() + " " + i + " : food" + i);
        }
    }
}