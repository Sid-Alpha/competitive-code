package interview.easy.strings;

import utils.info.Enhance;

import java.util.stream.IntStream;

@Enhance(details = "Reduce time")
public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int accumulator, currentNum, runner = 0;
        while(runner < prev.length()) {
            accumulator = 0;
            currentNum = prev.charAt(runner) - '0';
            while(runner < prev.length() && (prev.charAt(runner) - '0') == currentNum) {
                accumulator++;
                runner++;
            }
            sb.append(accumulator); sb.append(currentNum);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntStream.range(1,10).forEach(
                s ->  System.out.println(countAndSay(s))
        );
        System.out.println(countAndSay(70));

    }
}
