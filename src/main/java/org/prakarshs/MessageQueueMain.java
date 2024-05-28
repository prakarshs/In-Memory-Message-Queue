package org.prakarshs;

import org.prakarshs.Implementations.MessageQueueIMPL;
import org.prakarshs.Interfaces.MessageQueueInterface;
import org.prakarshs.Runners.MessageConsumer;
import org.prakarshs.Runners.MessageProducer;

import java.util.LinkedList;

public class MessageQueueMain {
    public static void main(String[] args) {
        MessageQueueInterface messageQueueInterface = new MessageQueueIMPL(new LinkedList<>(), 5L);

        MessageProducer messageProducer = new MessageProducer(messageQueueInterface);
        MessageConsumer messageConsumer = new MessageConsumer(messageQueueInterface);

        Thread pThread = new Thread(messageProducer);
        Thread pThread2 = new Thread(messageProducer);
        Thread pThread3 = new Thread(messageProducer);
        Thread cThread = new Thread(messageConsumer);
        Thread cThread2 = new Thread(messageConsumer);

        pThread.start();
        pThread2.start();
        pThread3.start();
        cThread.start();
        cThread2.start();

    }
}