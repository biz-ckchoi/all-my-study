package chapter05.complextree;

import org.junit.Assert;
import org.junit.Test;

public class ComplexTreeTest {

    @Test
    public void insert() {
        final Node<Integer> root = new Node<>(7, null, null);
        root.setLeft(new Leaf<>(root));
        root.setRight(new Leaf<>(root));

        root.insert(3);
        Assert.assertTrue(root.search(3));
        Assert.assertFalse(root.search(13));
    }

}
