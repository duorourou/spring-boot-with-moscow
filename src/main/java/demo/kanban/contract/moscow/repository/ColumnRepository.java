package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends MongoRepository<Column, String>{
}
