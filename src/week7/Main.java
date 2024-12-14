package week7;

public class Main
{
    public static void main(String[] args)
    {
        Plate plate = new Plate();
        Runnable mother = new Mother(plate);
        Runnable child = new Child(plate);

        Thread motherThread = new Thread(mother, "Mother");

        System.out.println(motherThread.getName() + " : " + motherThread.getState());
        Thread childThread = new Thread(child, "Child");

        System.out.println(childThread.getName() + " : " + childThread.getState());

        motherThread.start();
        childThread.start();

        System.out.println(motherThread.getName() + " : " + motherThread.getState());
        System.out.println(childThread.getName() + " : " + childThread.getState());

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted: " + e.getMessage());
        }

        System.out.println(motherThread.getName() + " : " + motherThread.getState());
        System.out.println(childThread.getName() + " : " + childThread.getState());
    }
}