package org.prakarshs.Interfaces;

import org.prakarshs.Model.Message;

public interface MessageQueueInterface {
    void addMessage(Message message) throws InterruptedException;
    Message getMessage() throws InterruptedException;
}
