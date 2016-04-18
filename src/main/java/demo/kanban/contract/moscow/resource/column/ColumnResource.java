package demo.kanban.contract.moscow.resource.column;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

/**
 * Created by xchou on 4/18/16.
 */
public class ColumnResource extends Resource<Column> {

    public ColumnResource(Column content, Link... links) {
        super(content, links);
    }

}
