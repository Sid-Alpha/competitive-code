
package interview.medium.math;

import utils.Pair;
import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/815/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class HappyNumber {
    private final static int[] squares = new int[] {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    public boolean isHappy(int n) {
        Set<Integer> numberRememberer = new HashSet<>();
        int digit, number = n, sum = 0;
        numberRememberer.add(number);
        while(true) {
            if (number == 0) {
                number = sum; sum = 0;
                if(number == 1) return true;
                if(numberRememberer.contains(number)) return false;
                numberRememberer.add(number);
            }
            digit = number%10;
            sum += squares[digit];
            number /= 10;
        }
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(2));
        System.out.println(IntStream.range(0, 100000)
                .boxed()
                .map(i -> new Pair<>(i, happyNumber.isHappy(i)))
                .filter(p -> p.second().equals(false))
                .map(Pair::first)
                .collect(Collectors.toList()));

    }
}
