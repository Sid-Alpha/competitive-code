package twopointer.medium;

import utils.info.Question;

@Question(url = "https://leetcode.com/problems/longest-repeating-character-replacement/")
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        return -1;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
        System.out.println(lrcr.characterReplacement("ABAB", 2));
        System.out.println(lrcr.characterReplacement("AABABBA", 1));
        System.out.println(lrcr.characterReplacement("AAAB", 0));
    }
}
