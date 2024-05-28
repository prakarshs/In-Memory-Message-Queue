package org.prakarshs.Implementations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.MessageQueueInterface;
import org.prakarshs.Model.Message;

import java.util.LinkedList;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageQueueIMPL implements MessageQueueInterface {
    private Queue<Message> queue = new LinkedList<>();
    private Long size;
    @Override
    public synchronized void addMessage(Message message) throws InterruptedException {
        if(size == queue.size())
            wait();
        queue.add(message);
        notifyAll();
    }

    @Override
    public synchronized Message getMessage() throws InterruptedException {
        if(queue.isEmpty())
            wait();
        Message message = queue.poll();
        notifyAll();
        return message;
    }
}
