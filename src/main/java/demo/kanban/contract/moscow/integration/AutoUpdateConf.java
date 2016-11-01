package demo.kanban.contract.moscow.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by xchou on 9/13/16.
 */
@Configuration
public class AutoUpdateConf {

    @Bean
    public MessageChannel initInputChannel(){
        return new DirectChannel();
    }


    @Bean
    MessageChannel cardsInputChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel cardInputChannel(){
        return new DirectChannel();
    }

    @Bean
    MessageChannel endChannel(){
        return new DirectChannel();
    }

    @Bean
    MessageHandler handler (){
        return message -> {
            System.out.println(message.getPayload());
        };
    }

    @Bean
    MessageHandler handler2 (){
        return message -> {
            System.out.println(message.getPayload());
        };
    }

    @Bean
    public IntegrationFlow updatingCardsFlow(CardActivator cardActivator,
                                             CardsActivator cardsActivator,
                                             CardsSplitter splitter){
        return IntegrationFlows.from(initInputChannel())
                .handle(cardsActivator)
                .channel(cardsInputChannel())
                .handle(splitter)
                .channel(cardInputChannel())
                .handle(cardActivator)
                .channel(endChannel())
                .aggregate()
                .handle(handler2())
                .get();
    }

    @Bean
    @DependsOn("updatingCardsFlow")
    public IntegrationFlow updatingCardFlow(CardActivator cardActivator,
                                            CardsSplitter splitter){
        return IntegrationFlows.from(cardsInputChannel())
                .handle(splitter)
                .channel(cardInputChannel())
                .handle(cardActivator)
                .channel(endChannel())
                .handle(handler())
                .get();
    }

}
