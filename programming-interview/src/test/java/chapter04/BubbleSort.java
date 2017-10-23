package chapter04;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {

    public void bubbleSort(int[] numbers) {
        boolean numbersSwitched;
        do {
            numbersSwitched = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i+1] < numbers[i]) {
                    int temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    numbersSwitched = true;
                }
            }
            printArray(numbers);
        } while (numbersSwitched);
    }

    @Test
    public void testBubbleSort() {
        final int[] numbers = {6, 4, 9, 5};
        final int[] expected = {4, 5, 6, 9};

        bubbleSort(numbers);
        Assert.assertArrayEquals(expected, numbers);
    }

    private void printArray(int[] numbers) {
        System.out.println(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

}
