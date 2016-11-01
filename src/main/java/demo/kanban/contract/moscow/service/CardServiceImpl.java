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
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import static demo.kanban.contract.moscow.resource.card.CardFields.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/18/16.
 */
@Service
public class CardServiceImpl implements CardService {

    private final List<String> customizedKeys = Arrays.asList(CARD_IN_RISK, CARD_PROGRESS,
                                                                CARD_START_DATE, CARD_DELIVERY_DATE, CARD_PARENT);

    @Autowired
    CardRepository cardRepository;

    @Autowired
    KanbanSeqsDao seqsDao;



    @Override
    public PagedResources<SimpleCardResource> getCardInColumn(String columnId) {
        Sort sort = new Sort(Sort.Direction.ASC, "metadata.leadDate");
        PageRequest pageRequest = new PageRequest(0, 20, sort);
        Page<Card> cards = cardRepository.findCardByColumn(new Column(columnId), pageRequest);

        SimpleCardResourceAssembler assembler = new SimpleCardResourceAssembler(customizedKeys);
        Link selfRel = linkTo(methodOn(CardController.class).getAllCards(null, columnId)).withSelfRel();
        return new SimpleCardPagedResourceAssembler(columnId)
                .toResource(cards, assembler, selfRel);
    }

    @Override
    public List<Card> getCardsInColumn(String columnId) throws UnknownHostException {


        return cardRepository.findByColumnAndDeleted(columnId, false);
//        return new SimpleCardResourceAssembler(
//                Arrays.asList(CARD_IN_RISK, CARD_PROGRESS, CARD_START_DATE, CARD_DELIVERY_DATE, CARD_PARENT))
//                .toResources(cards);
    }

    @Override
    public CardResource saveCard(Card card) {
        System.err.println("sequence card - number : " + seqsDao.getNextSeq("board_number"));
        cardRepository.save(card);
        return new CardResourceAssembler().toResource(card);
    }


    @Override
    public CardResource getCardById(String cardId) {
        return new CardResourceAssembler().toResource(cardRepository.findById(cardId));
    }
}
