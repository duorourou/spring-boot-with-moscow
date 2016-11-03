package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xchou on 4/18/16.
 */
public interface CardRepository extends JpaRepository<Card, Integer> {

//    @Query(fields = "{'_id': 1 , 'metadata': 1 , 'column' : 1}")
    Page<Card> findCardByColumn(Column colum, Pageable pageable);

    List<Card> findByColumnAndDeleted(Integer columnId, boolean deleted);

    default Card findById(Integer id) {
        Card card = this.findOne(id);
        return card != null && !card.isDeleted() ? card : null;
    }

}
