package dp;

import utils.info.Question;

@Question(
        question = "Number of Ways a given number can be represented as a sum of 1,3 & 4",
        details = "Same numbers with different ordering is a counted separately"
)
public class NumberAsDifferentSums {

    private int[] coinsAvailable = {1,3,4};

// 1 1 1 1
// 1 3
// 3 1
// 4


    public int numberOfWays(int N) {
        if(N < 0) return 0;
        if(N == 1 || N == 0 || N == 2) return 1;
        if(N == 3) return 2;
//        if(N == 4) return 3;
        return numberOfWays(N-1) + numberOfWays(N-3) + numberOfWays(N-4);
    }

    public static void main(String[] args) {
        System.out.println(new NumberAsDifferentSums().numberOfWays(5));
        System.out.println(new NumberAsDifferentSums().numberOfWays(10));
    }
}
