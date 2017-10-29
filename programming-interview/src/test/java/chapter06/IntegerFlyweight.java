package chapter06;

import org.junit.Assert;
import org.junit.Test;

public class IntegerFlyweight {

    @Test
    public void sameIntegerInstances() {
        final Integer a = Integer.valueOf(56);
        final Integer b = Integer.valueOf(56);

        Assert.assertSame(a, b);

        final Integer c = Integer.valueOf(472);
        final Integer d = Integer.valueOf(472);

        Assert.assertNotSame(c, d);
    }

}
