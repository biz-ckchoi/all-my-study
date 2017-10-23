package chapter04;

import org.junit.Assert;
import org.junit.Test;

public class ReverseTest {

    private final ReverseNumbericalOrder comparator = new ReverseNumbericalOrder();

    @Test
    public void testNeg() {
        Assert.assertTrue(comparator.compare(10, 4) < 0);
    }

    @Test
    public void testEq() {
        Assert.assertTrue(comparator.compare(2, 2) == 0);
    }

    @Test
    public void testPos() {
        Assert.assertTrue(comparator.compare(4, 10) > 0);
    }

}
