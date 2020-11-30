package interview.medium.math;

import utils.info.Question;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/819/")
public class Sqrt {

    public int mySqrt(int x) {
        long low = 0, high = x, mid;
        while (true) {
            mid = (low + high)/2;
            if(mid*mid <= x && (mid+1)*(mid+1) > x) return (int)mid;
            else if(mid * mid > x) high = mid -1;
            else low = mid + 1;
        }
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(4));
        System.out.println(sqrt.mySqrt(8));
        System.out.println(sqrt.mySqrt(9));
        System.out.println(sqrt.mySqrt(2147395599));
        System.out.println(sqrt.mySqrt(16));
    }
}
