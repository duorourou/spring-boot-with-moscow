package demo.kanban.contract.moscow.service;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import org.springframework.hateoas.Resources;

/**
 * Created by xchou on 4/18/16.
 */
public interface CardService {

    Resources<CardResource> getCardInColumn(String ColumnId) ;
    CardResource saveCard(Card card);
    CardResource getCardById(String cardId);
}
