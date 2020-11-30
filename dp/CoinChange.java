package dp;

import utils.info.Question;
import utils.info.UsedHints;

@Question(details = "ordering of coins doesn't matter")
@UsedHints
public class CoinChange {
    public int waysToGetChangeFor(final int[] coins, int N) {
        int[][] dpSolution = new int[coins.length][N+1];
        return waysToGetChangeHelper(coins, coins.length-1, N, dpSolution);
    }

    private int waysToGetChangeHelper(final int[] coins, int index, int sumRemaining, int[][] dpSolution) {
        if(sumRemaining == 0) return 1;
        if(sumRemaining < 0 || index < 0) return 0;
        if(dpSolution[index][sumRemaining]!=0) {
            return dpSolution[index][sumRemaining];
        }

        return dpSolution[index][sumRemaining] = waysToGetChangeHelper(coins, index-1, sumRemaining, dpSolution) +
                waysToGetChangeHelper(coins, index, sumRemaining - coins[index], dpSolution);
    }


    public static void main(String[] args) {
        System.out.println(new CoinChange().waysToGetChangeFor(new int[]{1, 2, 3, 33}, 5000));
        System.out.println(new CoinChange().waysToGetChangeFor(new int[]{1, 4, 5, 6, 7, 9}, 1009));
    }

}
