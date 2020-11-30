package twopointer.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.List;

import static java.util.Arrays.asList;

@Question(url = "https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/")
@Enhance(complexity = {Stat.SPACE, Stat.TIME})
public class LongestInDictionaryThroughDeletion {

    public String findLongestWord(String s, List<String> d) {
//        d.sort((o1, o2) -> {
//            if (o1.length() == o2.length()) return o1.compareTo(o2);
//            else return -1 * Integer.compare(o1.length(), o2.length());
//        });

        String currMax = "";
        for (String str : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) j++;
                i++;
            }
            if (j == str.length() && str.length() >= currMax.length())
                if (str.length() > currMax.length()) currMax = str;
                else if (str.compareTo(currMax) < 0) currMax = str;

        }

        return currMax;
    }

    public static void main(String[] args) {
        LongestInDictionaryThroughDeletion lw = new LongestInDictionaryThroughDeletion();

        System.out.println(lw.findLongestWord("abpcplea", asList("ale", "apple", "monkey", "plea")));
        System.out.println(lw.findLongestWord("abpcplea", asList("a", "b", "c")));
    }

}
