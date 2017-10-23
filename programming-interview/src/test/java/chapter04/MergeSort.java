package chapter04;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static List<Integer> mergeSort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }

        final List<Integer> leftHalf = values.subList(0, values.size() / 2);
        final List<Integer> rightHalf = values.subList(values.size() / 2, values.size());

        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left, final List<Integer> right) {
        int leftPointer = 0;
        int rightPointer = 0;

        final List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPointer < left.size() && rightPointer < right.size()) {
            if (left.get(leftPointer) < right.get(rightPointer)) {
                merged.add(left.get(leftPointer));
                leftPointer++;
            } else {
                merged.add(right.get(rightPointer));
                rightPointer++;
            }

            System.out.println("merge both::" + merged);
        }

        while (leftPointer < left.size()) {
            merged.add(left.get(leftPointer));
            leftPointer++;

            System.out.println("merge left::" + merged);
        }

        while (rightPointer < right.size()) {
            merged.add(right.get(rightPointer));
            rightPointer++;

            System.out.println("merge right::" + merged);
        }

        System.out.println("mered::" + merged);

        return merged;
    }

    @Test
    public void testMergedSort() {
        final List<Integer> numbers = Arrays.asList(6, 4, 9, 5);
        final List<Integer> expected = Arrays.asList(4, 5, 6, 9);

        final List<Integer> actual = mergeSort(numbers);
        Assert.assertEquals(expected, actual);
    }

}
