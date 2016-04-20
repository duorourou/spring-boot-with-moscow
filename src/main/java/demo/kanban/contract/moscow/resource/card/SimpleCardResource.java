package demo.kanban.contract.moscow.resource.card;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import java.util.HashMap;
import java.util.List;

import static demo.kanban.contract.moscow.resource.card.CardFields.*;

/**
 * Created by xchou on 4/20/16.
 */
public class SimpleCardResource extends Resource<SimpleCard> {

    public SimpleCardResource(Card card,  List<String> customizedToCoverFields, Link... links) {
        super(new SimpleCard(), links);
        getContent().setId(card.getId());
        covertMetadata(card);
        covertCustomizedFields(card,customizedToCoverFields);
    }

    private void covertMetadata(Card card) {
        HashMap<String, Object> metaMap = new HashMap<>();
        metaMap.put(CARD_TITLE, card.getMetadata().getOrDefault(CARD_TITLE, null));
        metaMap.put(CARD_NUMBER, card.getMetadata().getOrDefault(CARD_NUMBER, null));
        metaMap.put(CARD_TYPE, card.getMetadata().getOrDefault(CARD_TYPE, null));
        metaMap.put(CARD_LEAD_TIME, card.getMetadata().getOrDefault(CARD_LEAD_TIME, null));
        metaMap.put(CARD_IN_COLUMN_TIME, card.getMetadata().getOrDefault(CARD_IN_COLUMN_TIME, null));
        getContent().setMetadata(metaMap);
    }

    private void covertCustomizedFields(Card card , List<String> customizedToCoverFields) {
        HashMap<String, Object> customizedFields = new HashMap<>();
        customizedToCoverFields.forEach( key -> customizedFields.put(key, card.getMetadata().get(key)));
        getContent().setCustomizedFields(customizedFields);
    }

}
