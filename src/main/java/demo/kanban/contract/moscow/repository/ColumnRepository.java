package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by xchou on 4/18/16.
 */
public interface ColumnRepository extends MongoRepository<Column, String>{
}
