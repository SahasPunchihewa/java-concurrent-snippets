package test;

public class Producer implements Runnable
{
    private MailBox mailBox;

    public Producer(MailBox mailBox)
    {
        this.mailBox = mailBox;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            mailBox.addMessage("Message " + i);

            System.out.println("Producer wrote: Message " + i);
        }
    }
}