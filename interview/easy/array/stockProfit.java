package interview.easy.array;

public class stockProfit {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i=0,j;

        while (i < prices.length) {
            j=i;
            while (j+1 < prices.length && prices[j+1] > prices[i] && prices[j+1] > prices[j]) j++;

            maxProfit += prices[j] - prices[i];
            if(i==j) i++; else i=j;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4},
        prices2 = {1,2,3,4,5},
        prices3 = {7,6,4,3,1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }
}
