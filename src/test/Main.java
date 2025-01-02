package test;

public class Main
{
    public static void main(String[] args)
    {
        MailBox mailBox = new MailBox(5);

        Runnable producer = new Producer(mailBox);
        Runnable consumer = new Consumer(mailBox);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}