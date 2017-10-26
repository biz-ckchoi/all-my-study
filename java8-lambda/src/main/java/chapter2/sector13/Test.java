package chapter2.sector13;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Test {

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("java8-lambda/src/main/java/chapter2/alice.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));

        Stream<String> words = wordList.stream();

        // Very bad code ahead
        int[] shortWords = new int[10];
        words.parallel().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));

        // Try again--the result will likely be different (and also wrong)
        Arrays.fill(shortWords, 0);
        words = wordList.stream();
        words.parallel().forEach(s -> {
           if (s.length() < 10) {
               shortWords[s.length()]++;
           }
        });
        System.out.println(Arrays.toString(shortWords));

        // Sequential stream works ok
        Arrays.fill(shortWords, 0);
        words = wordList.stream();
        words.forEach(s -> {
           if (s.length() < 10) {
               shortWords[s.length()]++;
           }
        });

        // Atomic integers
        AtomicInteger[] shortWordCounters = new AtomicInteger[10];
        for (int i = 0; i < shortWordCounters.length; i++) {
            shortWordCounters[i] = new AtomicInteger();
        }
        words = wordList.stream();
        words.forEach(s -> {
            if (s.length() < 10) {
                shortWordCounters[s.length()].getAndIncrement();
            }
        });
        System.out.println(Arrays.toString(shortWordCounters));

        // Grouping works in parallel
        words = wordList.stream();
        System.out.println(words.parallel().filter(s -> s.length() < 10).collect(groupingBy(String::length, counting())));

    }

}
/*
[1, 1724, 4303, 6028, 5152, 3220, 2053, 1751, 802, 673]
[1, 1803, 4783, 7117, 5877, 3483, 2168, 1834, 823, 691]
[1, 1826, 4999, 7637, 6166, 3589, 2203, 1867, 831, 697]
{0=1, 1=1826, 2=4999, 3=7637, 4=6166, 5=3589, 6=2203, 7=1867, 8=831, 9=697}
 */