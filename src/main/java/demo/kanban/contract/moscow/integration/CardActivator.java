package demo.kanban.contract.moscow.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by xchou on 9/13/16.
 */
@MessageEndpoint
public class CardActivator {

    @ServiceActivator
    public Message<String> updateCard(@Payload String card){
            return MessageBuilder.withPayload("card " + System.currentTimeMillis()).build();
    }
}
