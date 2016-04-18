package demo.kanban.contract.moscow;

import com.github.macdao.moscow.ContractContainer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.Paths;

/**
 * Created by xchou on 4/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public class ApplicationTest {

    private static final ContractContainer contractContainer = new ContractContainer(Paths.get("src/test/resources/contracts"));

    @Rule
    public final TestName name = new TestName();
    @Value("${local.server.port}")
    protected int port;



//    protected Map<String, String> assertContract(String description) {
//
////        return new ContractAssertion(contractContainer.findContracts(description))
////                .setPort(port)
////                .setExecutionTimeout(200)
////                .assertContract();
//    }

    @Test
    public void testGetMoscow() throws Exception {
//        assertContract("should_response_user_details_as_json");

    }
}