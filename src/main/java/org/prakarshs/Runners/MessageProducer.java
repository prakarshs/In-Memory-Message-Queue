package org.prakarshs.Runners;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.MessageQueueInterface;
import org.prakarshs.Model.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageProducer implements Runnable {
    private MessageQueueInterface messageQueueInterface;

    @Override
    public void run() {
        try{
            for(int i = 1; i<=10; i++) {
                Message message = new Message("Message Number : " + i);
                messageQueueInterface.addMessage(message);
                System.out.println("Produced : " + message);
                Thread.sleep(150);
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
