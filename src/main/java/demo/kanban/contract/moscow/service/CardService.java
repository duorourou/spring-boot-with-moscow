package demo.kanban.contract.moscow.service;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.resource.card.SimpleCardResource;
import org.springframework.hateoas.PagedResources;

import java.util.List;

/**
 * Created by xchou on 4/18/16.
 */
public interface CardService {

    PagedResources<SimpleCardResource> getCardInColumn(String ColumnId);

    CardResource saveCard(Card card);

    CardResource getCardById(String cardId);

    List<SimpleCardResource> getCardsInColumn(String columnId);

}
