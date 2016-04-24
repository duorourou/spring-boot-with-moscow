package demo.kanban.contract.moscow.service;

import demo.kanban.contract.moscow.controller.CardController;
import demo.kanban.contract.moscow.controller.CardResourceAssembler;
import demo.kanban.contract.moscow.controller.SimpleCardPagedResourceAssembler;
import demo.kanban.contract.moscow.controller.SimpleCardResourceAssembler;
import demo.kanban.contract.moscow.repository.CardRepository;
import demo.kanban.contract.moscow.repository.KanbanSeqsDao;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.resource.card.SimpleCardResource;
import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static demo.kanban.contract.moscow.resource.card.CardFields.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/18/16.
 */
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    KanbanSeqsDao seqsDao;

    @Override
    public PagedResources<SimpleCardResource> getCardInColumn(String columnId) {
        Page<Card> cards = cardRepository.findCardByColumn(new Column(columnId), new PageRequest(0, 20));
        if (Objects.isNull(cards)) {
            return null;
        }
        return new SimpleCardPagedResourceAssembler(columnId)
                .toResource(cards,
                        new SimpleCardResourceAssembler(
                                Arrays.asList(CARD_IN_RISK, CARD_PROGRESS, CARD_START_DATE, CARD_DELIVERY_DATE, CARD_PARENT)),
        linkTo(methodOn(CardController.class).getAllCards(columnId)).withSelfRel());
    }

    @Override
    public List<SimpleCardResource> getCardsInColumn(String columnId) {
        Iterable<Card> cards = cardRepository.findAll(Arrays.asList("57179778d4c61a45b771b2fb" ,"57179c20d4c6bb0dff727bd4"));
        return new SimpleCardResourceAssembler(
                Arrays.asList(CARD_IN_RISK, CARD_PROGRESS, CARD_START_DATE, CARD_DELIVERY_DATE, CARD_PARENT))
                .toResources(cards);
    }

    @Override
    public CardResource saveCard(Card card) {
        System.err.println("sequence card - number : " + seqsDao.getNextSeq("board_number"));
        cardRepository.save(card);
        return new CardResourceAssembler().toResource(card);
    }



    @Override
    public CardResource getCardById(String cardId) {
        return new CardResourceAssembler().toResource(cardRepository.findOne(cardId));
    }
}
