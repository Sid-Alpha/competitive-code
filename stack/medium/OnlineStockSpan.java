package stack.medium;

import javafx.util.Pair;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;
import utils.info.UsedHints;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/online-stock-span/")
@UsedHints
@Enhance(reduce = {Stat.SPACE, Stat.TIME})
public class OnlineStockSpan {

    public static class StockSpanner {

        private final Stack<Pair<Integer, Integer>> stockData;

        public StockSpanner() {
            stockData = new Stack<>();
        }

        public int next(int price) {
            if (stockData.size() == 0) {
                stockData.push(new Pair<>(price, 1));
                return 1;
            }

            int killCount = 0;
            while (!stockData.isEmpty() && price >= stockData.peek().getKey()) killCount += stockData.pop().getValue();

            stockData.push(new Pair<>(price, killCount + 1));

            return killCount + 1;
        }

    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
//        System.out.println(stockSpanner.next(100));
//        System.out.println(stockSpanner.next(80));
//        System.out.println(stockSpanner.next(60));
//        System.out.println(stockSpanner.next(70));
//        System.out.println(stockSpanner.next(60));
//        System.out.println(stockSpanner.next(75));
//        System.out.println(stockSpanner.next(85));

        System.out.println(stockSpanner.next(32));
        System.out.println(stockSpanner.next(82));
        System.out.println(stockSpanner.next(73));
        System.out.println(stockSpanner.next(99));
        System.out.println(stockSpanner.next(91));
    }


}
