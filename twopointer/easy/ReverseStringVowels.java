package twopointer.easy;

import interview.easy.linkedlist.Reverse;
import utils.info.Question;

import java.util.HashSet;

@Question(url = "https://leetcode.com/problems/reverse-vowels-of-a-string/")
public class ReverseStringVowels {
    private static final HashSet<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        char c;
        while (true) {
            while (i < str.length && !VOWELS.contains(str[i])) i++;
            while (j >= 0 && !VOWELS.contains(str[j])) j--;

            if (i > j) break;
            if (i < str.length) {
                c = str[i];
                str[i++] = str[j];
                str[j--] = c;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        ReverseStringVowels reverseStringVowels = new ReverseStringVowels();
        System.out.println(reverseStringVowels.reverseVowels("bb"));
        System.out.println(reverseStringVowels.reverseVowels("hello"));
        System.out.println(reverseStringVowels.reverseVowels("leetcode"));
    }
}
