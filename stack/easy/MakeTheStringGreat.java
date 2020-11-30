package stack.easy;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/make-the-string-great/")
@Enhance(reduce = {Stat.SPACE}, updated = true)
public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            }
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i ++) sb.append(stack.elementAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        System.out.println(makeTheStringGreat.makeGood("leEeetcode"));
        System.out.println(makeTheStringGreat.makeGood("abBAcC"));
        System.out.println(makeTheStringGreat.makeGood("s"));
        System.out.println(makeTheStringGreat.makeGood(""));
        System.out.println(makeTheStringGreat.makeGood("Pp"));
        System.out.println(makeTheStringGreat.makeGood("pP"));
    }
}
