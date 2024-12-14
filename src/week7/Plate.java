package week7;

public class Plate
{
    private String food;
    private Boolean availability = false;

    public synchronized void serve(String food)
    {
        while (availability)
        {
            try
            {
                wait(100);
            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }

        this.food = food;
        availability = true;

        notifyAll();
    }

    public synchronized String consume()
    {
        while (!availability)
        {
            try
            {
                wait(100);
            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }

        availability = false;
        notifyAll();
        return food;
    }
}