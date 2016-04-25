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
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<String> ids = Arrays.asList("57179602d4c609b02e81c74d",
        "57179679d4c6f1f045b76522",
        "571796b5d4c6f1f045b76523",
        "571796c6d4c6f1f045b76524",
        "57179778d4c61a45b771b2fb",
        "5717985bd4c672b4ee037e44",
        "57179ab3d4c643217fbbdfc8",
        "57179c20d4c6bb0dff727bd4",
        "57179c51d4c6829f405075a6",
        "5717a07ed4c696e26833d86b",
        "5717a138d4c6f4163d37c74e",
        "5717a264d4c6385b9db0b86f",
        "5717a308d4c6385b9db0b870",
        "571a36a4a7c8591f30b8a0ec",
        "571ac289d4c6ac578dd4c088",
        "571ac358d4c6b48aa953b9a3",
        "571ac36ed4c6cb310c7f08f8",
        "571ac4a6d4c68b74fd997d20",
        "571ac4b3d4c614854ea4ad4c",
        "571ac4ccd4c6c5587b468c95");
        Page<Card> cards = cardRepository.findCardByColumn(new Column(columnId), new PageRequest(0, 20));
        Map<String , Card> resultMap = cards.getContent().stream().collect(Collectors.toMap(Card::getId , card -> card));

//        cards.getContent().removeAll(cards.getContent());
//        cards.getContent().addAll(ids.stream().collect(Collectors.mapping(cardId -> resultMap.get(cardId) , Collectors.toList())));

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
