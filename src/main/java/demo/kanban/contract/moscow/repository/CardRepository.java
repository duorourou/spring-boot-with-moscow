package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by xchou on 4/18/16.
 */
public interface CardRepository extends MongoRepository<Card, String>{
    Page<Card> findCardByColumn(Column colum, Pageable pageable);

}
