package demo.kanban.contract.moscow.service;

import demo.kanban.contract.moscow.controller.CardResourceAssembler;
import demo.kanban.contract.moscow.repository.CardRepository;
import demo.kanban.contract.moscow.repository.ColumnRepository;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by xchou on 4/18/16.
 */
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ColumnRepository columnRepository;

    @Override
    public Resources<CardResource> getCardInColumn(String columnId) {
        List<Card>  cards = cardRepository.findCardByColumn(new Column(columnId));
        if (Objects.isNull(cards))
            return new Resources<>(null);
        else
            return new Resources<>(new CardResourceAssembler().toResources(cards));
    }

    @Override
    public CardResource saveCard(Card card) {
        return new CardResourceAssembler().toResource(cardRepository.save(card));
    }

    @Override
    public CardResource getCardById(String cardId) {
        return new CardResourceAssembler().toResource(cardRepository.findOne(cardId));
    }
}
