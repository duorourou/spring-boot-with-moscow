package demo.kanban.contract.moscow.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xchou on 9/13/16.
 */
@MessageEndpoint
public class CardsSplitter extends AbstractMessageSplitter {

    @Override
    protected List<Message<String>> splitMessage(Message<?> message) {
        List<String> slist = (List<String>) message.getPayload();
        return slist.stream().map(s -> MessageBuilder.withPayload(s).build()).collect(Collectors.toList());
    }

}
