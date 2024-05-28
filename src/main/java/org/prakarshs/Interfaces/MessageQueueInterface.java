package org.prakarshs.Interfaces;

import org.prakarshs.Model.Message;

public interface MessageQueueInterface {
    void enqueue(Message message);
    Message dequeue();
}
