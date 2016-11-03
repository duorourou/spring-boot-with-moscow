package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository<Column, Integer> {
}
