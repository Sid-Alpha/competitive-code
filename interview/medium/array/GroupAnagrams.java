package interview.medium.array;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/")
@Enhance(complexity = Stat.TIME)
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ll = new HashMap<>();
        for(String s: strs) {
            char[] c  = s.toCharArray(); Arrays.sort(c); String newStr = new String(c);
            List<String> newL = ll.getOrDefault(newStr, new ArrayList<>());
            newL.add(s);
            ll.put(newStr, newL);
        }
        return new ArrayList<>(ll.values());
    }

    private class Anagram {
        private long total = 0, len;

        public Anagram(String s) {
            len = s.length();
            for(char c : s.toCharArray()) total += c;
        }
        public boolean isAnagram(String input) {
            if(input.length() != len) return false;
            long ntotal = 0;
            for (char c : input.toCharArray()) ntotal += c;
            return total == ntotal;
        }
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
