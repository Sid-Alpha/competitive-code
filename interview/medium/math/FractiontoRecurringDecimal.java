package interview.medium.math;

import utils.info.Garbage;
import utils.info.Question;
import utils.info.Unfinished;
import utils.info.UsedHints;

import java.util.HashMap;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/821/")
@Unfinished
@Garbage
public class FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        float op = (float) numerator/denominator;
        String str = String.valueOf(op);
        StringBuilder pre = new StringBuilder(), post = new StringBuilder();
        HashMap<Integer, Integer> repeat = new HashMap<>();
        boolean postDecimal = false;
        int count = 0;
        for(char c : str.toCharArray()) {
            if (!postDecimal ) pre.append(c);
            if (c == '.') postDecimal = true;
            if (postDecimal && c != '.'){
                if(repeat.containsKey(c-'0')) {
                    post.insert(repeat.get(c-'0'), "(");
                    return pre.toString() + post + ")";
                }
                repeat.put(c-'0', count);
                post.append(c);
                count++;
            }
        }
        if(post.toString().equals("0")) { pre.deleteCharAt(pre.length()-1); return pre.toString(); }
        return pre.toString() + post.toString();
    }

    public static void main(String[] args) {
        FractiontoRecurringDecimal fractiontoRecurringDecimal = new FractiontoRecurringDecimal();
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1, 2));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(2, 1));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(2, 3));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1, 6));
    }
}
