package demo.kanban.contract.moscow;

import com.google.gson.Gson;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.column.Column;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

/**
 * Created by xchou on 4/12/16.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        Column column = new Column();
        column.setLaneName("coco name");
        column.setLaneDesc("coco desc");
        column.setCreatedAt(new Date());

        System.out.println(new Gson().toJson(column));

        Card card = new Card();
        card.setCardId("TE-1");
        card.setTitle("title abc");
        card.setType("story");
        card.setColumn(column);

        System.out.println(new Gson().toJson(card));
        SpringApplication.run(Application.class, args);
    }
}
