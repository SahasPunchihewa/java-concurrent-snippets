package week5;

public class Main
{
    public static final String lock1 = "lock1";
    public static final String lock2 = "lock2";

    public static void main(String[] args)
    {
        //        Thread numberThread = new Number("Number Thread");
        //        Thread alphabetThread = new Thread(new Alphabet(), "Alphabet Thread");
        //
        //        System.out.println(numberThread.getState());
        //
        //        numberThread.start();
        //        alphabetThread.start();
        //
        //        try
        //        {
        //            numberThread.join();
        //            alphabetThread.join();
        //        }
        //        catch (Exception ex)
        //        {
        //            System.out.println("Error: " + ex.getMessage());
        //        }

        Thread t1 = new Thread(() ->
        {
            synchronized (lock1)
            {
                System.out.println("Thread 1: locked resource 1");

                try
                {
                    Thread.sleep(100);
                }
                catch (Exception e)
                {
                    System.out.println("Error: " + e.getMessage());
                }

                synchronized (lock2)
                {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread(() ->
        {
            synchronized (lock2)
            {
                System.out.println("Thread 2: locked resource 2");

                try
                {
                    Thread.sleep(100);
                }
                catch (Exception e)
                {
                    System.out.println("Error: " + e.getMessage());
                }

                synchronized (lock1)
                {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        t1.start();
        t2.start();

        System.out.println(t2.getState());
        System.out.println(t1.getState());
    }
}