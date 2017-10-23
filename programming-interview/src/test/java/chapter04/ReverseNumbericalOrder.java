package chapter04;

import java.util.Comparator;

public class ReverseNumbericalOrder implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

    // 같은 부분은 생략함

}
