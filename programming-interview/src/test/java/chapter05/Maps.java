package chapter05;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Maps {

    @Test
    public void overwriteKey() {
        final Map<String, String> preferences = new HashMap<>();
        preferences.put("like", "jacuzzi");
        preferences.put("dislike", "steam room");

        System.out.println("HashMap :: " + preferences);

        Assert.assertEquals("jacuzzi", preferences.get("like"));

        preferences.put("like", "sauna");

        Assert.assertEquals("sauna", preferences.get("like"));
    }

    @Test
    public void treeMapTraversal() {
        final Map<Integer, String> counts = new TreeMap<>();
        counts.put(4, "four");
        counts.put(1, "one");
        counts.put(3, "three");
        counts.put(2, "two");

        System.out.println("TreeMap :: " + counts);

        final Iterator<Integer> keys = counts.keySet().iterator();
        Assert.assertEquals(Integer.valueOf(1), keys.next());
        Assert.assertEquals(Integer.valueOf(2), keys.next());
        Assert.assertEquals(Integer.valueOf(3), keys.next());
        Assert.assertEquals(Integer.valueOf(4), keys.next());
        Assert.assertFalse(keys.hasNext());
    }

    @Test
    public void linkedHashMapTraversal() {
        final Map<Integer, String> counts = new LinkedHashMap<>();
        counts.put(4, "four");
        counts.put(1, "one");
        counts.put(3, "three");
        counts.put(2, "two");

        System.out.println("LinkedHashMap :: " + counts);

        final Iterator<Integer> keys = counts.keySet().iterator();
        Assert.assertEquals(Integer.valueOf(4), keys.next());
        Assert.assertEquals(Integer.valueOf(1), keys.next());
        Assert.assertEquals(Integer.valueOf(3), keys.next());
        Assert.assertEquals(Integer.valueOf(2), keys.next());
        Assert.assertFalse(keys.hasNext());
    }

}
