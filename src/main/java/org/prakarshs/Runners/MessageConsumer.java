package org.prakarshs.Runners;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.MessageQueueInterface;
import org.prakarshs.Model.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageConsumer implements Runnable{
    private MessageQueueInterface messageQueueInterface;

    @Override
    public void run() {
        try {
            for(int i = 1; i<=10; i++) {
                Message message = messageQueueInterface.getMessage();
                System.out.println("Consumed : " + message);
                Thread.sleep(250);
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
