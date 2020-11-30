package interview.easy.strings;

import utils.info.Question;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/")
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String p = strs[0];
        for(String s : strs) while (!s.startsWith(p) && p.length() != 0) p = p.substring(0, p.length()-1);
        return p;
    }

    public static void main(String[] args) {
        System.out.println("Common prefix -> " + longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println("Common prefix -> " + longestCommonPrefix(new String[] {"flower","vbn","xzy"}));
    }
}

