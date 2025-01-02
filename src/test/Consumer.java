package test;

public class Consumer implements Runnable
{
    private MailBox mailBox;

    public Consumer(MailBox mailBox)
    {
        this.mailBox = mailBox;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            String message = mailBox.readMessage();

            System.out.println("Consumer read: " + message);
        }
    }
}