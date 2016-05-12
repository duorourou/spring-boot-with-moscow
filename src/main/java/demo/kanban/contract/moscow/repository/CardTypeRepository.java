package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.card.type.CardType;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by xchou on 5/12/16.
 */
public interface CardTypeRepository extends MongoRepository<CardType, String> {
}
