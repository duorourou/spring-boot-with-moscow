package demo.kanban.contract.moscow.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by xchou on 9/13/16.
 */
@MessageEndpoint
public class CardsActivator {

    @ServiceActivator
    public Message<ArrayList<String>> updateCard(@Payload String msg){
        return MessageBuilder.withPayload(newArrayList("A", "B", "C", "D")).build();
    }
}
