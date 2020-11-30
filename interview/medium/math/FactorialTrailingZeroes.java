package interview.medium.math;

import utils.info.Question;
import utils.info.UsedHints;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/816/")
@UsedHints
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n/5);
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes fz = new FactorialTrailingZeroes();
        System.out.println(fz.trailingZeroes(3));
        System.out.println(fz.trailingZeroes(5));
        System.out.println(fz.trailingZeroes(25));
    }
}
