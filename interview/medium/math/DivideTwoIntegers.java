package interview.medium.math;

import utils.info.Garbage;
import utils.info.Question;
import utils.info.Unfinished;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/820/")
@Unfinished
@Garbage
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int negativeIndicator = 1, result;
        long Ldivisor = divisor, Ldividened = dividend;
        long quotient = 0;
        if(Ldividened < 0) {
            negativeIndicator *= -1;
            Ldividened *= -1;
        }
        if(Ldivisor < 0) {
            negativeIndicator *= -1;
            Ldivisor *= -1;
        }

        while (Ldividened >= Ldivisor) {
            Ldividened -= Ldivisor;
            quotient++;
        }
        if (negativeIndicator < 0)
            result = (quotient > (long)Integer.MAX_VALUE + 1) ? Integer.MAX_VALUE : (int)quotient * negativeIndicator;
        else
            result = (quotient > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int)quotient;

        return result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
//        System.out.println(divideTwoIntegers.divide(10, 3));
//        System.out.println(divideTwoIntegers.divide(7, -3));
//        System.out.println(divideTwoIntegers.divide(1, 1));
        System.out.println(divideTwoIntegers.divide(-2147483648,-1));
        System.out.println(divideTwoIntegers.divide(2147483647, 2));
    }

}
