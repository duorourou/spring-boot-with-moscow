package demo.kanban.contract.moscow;

import demo.kanban.contract.moscow.repository.CardRepository;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.column.Column;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xchou on 4/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public class ApplicationTest {

//    private static final ContractContainer contractContainer = new ContractContainer(Paths.get("src/test/resources/contracts"));

    @Rule
    public final TestName name = new TestName();
    @Value("${local.server.port}")
    protected int port;

    @Autowired
    private CardRepository cardRepository;


//    protected Map<String, String> assertContract(String description) {
//
////        return new ContractAssertion(contractContainer.findContracts(description))
////                .setPort(port)
////                .setExecutionTimeout(200)
////                .assertContract();
//    }

    @Test
    public void testGetMoscow() throws Exception {

        Card card = null;
        for (int i = 0; i < 100; i++) {
            card = new Card(i);
            card.setColumn(new Column("572b520bdbb070d54d63b510"));
            cardRepository.save(card);
        }
        System.out.println(System.currentTimeMillis());
        cardRepository.findByColumnAndDeleted("572b520bdbb070d54d63b510", false);
        System.out.println(System.currentTimeMillis());
//        assertContract("should_response_user_details_as_json");

    }
}