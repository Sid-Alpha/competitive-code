package interview.easy.dp;

import utils.info.UsedHints;

@UsedHints
public class BestTimeToBuyAndSell {

//    public int maxProfit(int[] prices) {
//        int bestPrice = 0;
//        for(int buy=0; buy < prices.length - 1; buy++) {
//            if (buy != 0 && prices[buy - 1] < prices[buy]) continue;
//            for (int sell = buy + 1; sell < prices.length; sell++) {
//                if ((prices[sell] - prices[buy]) > bestPrice) bestPrice = prices[sell] - prices[buy];
//            }
//        }
//        return bestPrice;
//    }

    public int maxProfit(int[] prices) {
//        if(prices.length == 0 || prices.length == 1) return 0;
//        int min = prices[0], maxP = 0;
//        for(int i = 1; i < prices.length; i ++) {
//            if(prices[i] < min) {
//                min = prices[i];
//            }
//            else {
//                maxP = Math.max(maxP, prices[i] - min);
//            }
//        }
//        return maxP;


        int buy = 0, sell= 0;
        for(int i: prices) {
            if(i < prices[buy]) buy = i;
            if(i > prices[sell]) sell = i;
        }
        return sell - buy > 0 ? sell - buy : 0;




//        int curr = 0, maxP = 0;
//        for(int i = 1; i < prices.length; i++) {
//            curr = Math.max(0, curr+= prices[i] - prices[i-1]);
//            maxP = Math.max(curr, maxP);
//        }
//        return maxP;
    }


    public static void main(String[] args) {
        int[] arr1 = {7,1,5,3,6,4},
        arr2 = {7,6,4,3,1}
                ;

        System.out.println(new BestTimeToBuyAndSell().maxProfit(arr1));
        System.out.println(new BestTimeToBuyAndSell().maxProfit(arr2));

    }
}
