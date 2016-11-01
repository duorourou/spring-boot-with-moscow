package demo.kanban.contract.moscow.mq;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xchou on 7/3/16.
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
