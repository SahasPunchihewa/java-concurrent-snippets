package test;

import java.util.LinkedList;
import java.util.Queue;

public class MailBox
{
    private Queue<String> messages;
    private Integer capacity;

    public MailBox(Integer capacity)
    {
        this.capacity = capacity;
        this.messages = new LinkedList<>();
    }

    public synchronized void addMessage(String message)
    {
        while (messages.size() == capacity)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
                System.out.println("Thread interrupted: " + ex);
            }
        }

        messages.add(message);
        notifyAll();
    }

    public synchronized String readMessage()
    {
        while (messages.isEmpty())
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
                System.out.println("Thread interrupted: " + ex);
            }
        }

        String message = messages.poll();
        notifyAll();
        return message;
    }
}