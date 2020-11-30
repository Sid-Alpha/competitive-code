package twopointer.medium;

import utils.info.Garbage;
import utils.info.Question;
import utils.info.Unfinished;

@Question(url = "https://leetcode.com/problems/fruit-into-baskets/")
@Unfinished
@Garbage
public class FruitsIntoBasket {

    public int totalFruit(int[] tree) {
        return -1;
    }

    public static void main(String[] args) {
        FruitsIntoBasket fruitsIntoBasket = new FruitsIntoBasket();
        System.out.println(fruitsIntoBasket.totalFruit(new int[] {1,2,1})); // 3
        System.out.println(fruitsIntoBasket.totalFruit(new int[] {0,1,2,2}));   // 3
        System.out.println(fruitsIntoBasket.totalFruit(new int[] {1,2,3,2,2})); //4
        System.out.println(fruitsIntoBasket.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4})); // 5
        System.out.println(fruitsIntoBasket.totalFruit(new int[] {0,1,6,6,4,4,6})); // 5
        System.out.println(fruitsIntoBasket.totalFruit(new int[] {5,9,0,9,6,9,6,9,9,9})); // 7
    }
}
