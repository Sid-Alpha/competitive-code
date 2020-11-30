package interview.medium.dp;

import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.UsedHints;

@Question(
        url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/111/dynamic-programming/809/",
        details = "Check non DP solutions"
)
@UsedHints
@NewAlgo(details = "TODO: Learn https://en.wikipedia.org/wiki/Change-making_problem")
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return coinChangeHelper(coins, amount, new int[amount]);
    }

    private int coinChangeHelper(int[] coins, int amount, int[] minCoinsForAmount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(minCoinsForAmount[amount-1] != 0) return minCoinsForAmount[amount-1];

        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins) {
            int val = coinChangeHelper(coins,
                    amount - coin,
                    minCoinsForAmount);
            if(val != -1 && val < minCoins) minCoins = val + 1;
        }

        minCoinsForAmount[amount-1] = ((minCoins == Integer.MAX_VALUE) ? -1 : minCoins);
        return minCoinsForAmount[amount-1];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[] {1, 2, 5}, 11));
        System.out.println(cc.coinChange(new int[] {2}, 3));
        System.out.println(cc.coinChange(new int[] {1,2147483647}, 2));
        System.out.println(cc.coinChange(new int[] {1, 2, 5}, 100));    // 20
//        System.out.println(cc.coinChange(new int[] {1}, 2147483647));
    }
}
