package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.card.KanbanSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class KanbanSeqsDao  {

    @Autowired
    MongoTemplate template;

    public long getNextSeq(String name){

        Query query = new Query();

        query.addCriteria(new Criteria("_id").is(name));

        KanbanSequence sequence = template.findAndModify(query,
                new Update().inc("seq" , 1), FindAndModifyOptions.options().upsert(true).returnNew(true) , KanbanSequence.class);

        return sequence.getSeq();
    }

}
