package chapter05;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    @Test
    public void queueInsertion() {
        final Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");

        Assert.assertEquals("first", queue.remove());
        Assert.assertEquals("second", queue.remove());
        Assert.assertEquals("third", queue.peek());
        Assert.assertEquals("third", queue.remove());
    }

}
