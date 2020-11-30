package interview.medium.backtracking;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Question(url = "https://leetcode.com/submissions/detail/354531950/?from=/explore/interview/card/top-interview-questions-medium/109/backtracking/793/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class LetterCombinationsOfaPhoneNumber {

    private static final char[][] numberToInteger = new char[][] {
            {'a', 'b', 'c'},        // 2
            {'d', 'e', 'f'},        // 3
            {'g', 'h', 'i'},        // 4
            {'j', 'k', 'l'},        // 5
            {'m', 'n', 'o'},        // 6
            {'p', 'q', 'r', 's'},   // 7
            {'t', 'u', 'v'},        // 8
            {'w', 'x', 'y', 'z'}    // 9
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();

        int[] numbers = new int[digits.length()];
        int count = 0;
        for (char c : digits.toCharArray()) numbers[count++] = Integer.parseInt(c + "");

        List<String> letterCombinations = new ArrayList<>();
        letterCombinationsHelper(numbers, 0, new StringBuilder(), letterCombinations);

        return letterCombinations;
    }

    private void letterCombinationsHelper(int[] numbers, int currentIndex, StringBuilder currentString, List<String> finalList) {
        if(numbers.length <= currentIndex) {
            finalList.add(currentString.toString());
            return;
        }
        for(char c : numberToInteger[numbers[currentIndex]-2]) {
            currentString.append(c);
            letterCombinationsHelper(numbers, currentIndex+1, currentString, finalList);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber letterCombinationsOfaPhoneNumber = new LetterCombinationsOfaPhoneNumber();
        System.out.println(letterCombinationsOfaPhoneNumber.letterCombinations("23"));
    }
}
