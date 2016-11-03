package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.card.type.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xchou on 5/12/16.
 */
public interface CardTypeRepository extends JpaRepository<CardType, Integer> {
}
