package array.easy;

import utils.info.Question;

import java.util.ArrayList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/")
public class KidsWiththeGreatestNumberofCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> answer = new ArrayList<>(candies.length);

        for (int c : candies) if (c > max) max = c;

        for (int c : candies)
            answer.add((c + extraCandies) >= max);

        return answer;
    }

    public static void main(String[] args) {
        KidsWiththeGreatestNumberofCandies kidsWiththeGreatestNumberofCandies = new KidsWiththeGreatestNumberofCandies();
        System.out.println(kidsWiththeGreatestNumberofCandies.kidsWithCandies(new int[] {2,3,5,1,3}, 3));
        System.out.println(kidsWiththeGreatestNumberofCandies.kidsWithCandies(new int[] {4,2,1,1,2}, 1));
    }

}
