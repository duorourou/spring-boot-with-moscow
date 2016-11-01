package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by xchou on 4/18/16.
 */
public interface CardRepository extends MongoRepository<Card, String> {

//    @Query(fields = "{'_id': 1 , 'metadata': 1 , 'column' : 1}")
    Page<Card> findCardByColumn(Column colum, Pageable pageable);

    List<Card> findByColumnAndDeleted(String columnId, boolean deleted);

    default Card findById(String id) {
        Card card = this.findOne(id);
        return card != null && !card.isDeleted() ? card : null;
    }

}
