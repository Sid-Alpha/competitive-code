package interview.medium.array;

import interview.easy.RunTimeCompute;
import utils.info.Stat;
import utils.info.Enhance;
import utils.info.NewAlgo;
import utils.info.Question;

import java.util.HashSet;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/")
@Enhance(complexity = Stat.TIME, details = "Optimize sliding window")
@NewAlgo(details = "Sliding window")
public class LongestSubstringWithoutCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>();
        int maxLen = 0, start = 0, end = 0;
        while (end < s.length()) {
            while (chars.contains(s.charAt(end)))
                chars.remove(s.charAt(start++));
            chars.add(s.charAt(end));
            maxLen = Math.max(end - start + 1, maxLen);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutCharacters ll = new LongestSubstringWithoutCharacters();
//        System.out.println(ll.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(ll.lengthOfLongestSubstring("dvdf"));
//        System.out.println(ll.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(ll.lengthOfLongestSubstring("bbbbbb"));

        RunTimeCompute.compute(() -> ll.lengthOfLongestSubstring("asdadasdadasdasdakhflkashdufiweifcisdlafakiflahakjlaifhi"));
    }

}
