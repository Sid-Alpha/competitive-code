package interview.medium.math;

import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/817/")
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int total = 0, raise = 0;
        for(int i = s.length()-1; i >= 0 ; i--)
            total += Math.pow(26, raise++) * (s.charAt(i)-'A' + 1);

        return total;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("A"));
        System.out.println(excelSheetColumnNumber.titleToNumber("AB"));
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }
}
