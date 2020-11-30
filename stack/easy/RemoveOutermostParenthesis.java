package stack.easy;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/remove-outermost-parentheses/")
@Enhance(reduce = Stat.TIME)
public class RemoveOutermostParenthesis {

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int closeHelp = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            stack.push(c);
            if (c == '(') closeHelp++;
            else closeHelp--;

            if (closeHelp == 0) {
                for (int i = 1; i < stack.size() - 1; i ++)
                    sb.append(stack.elementAt(i));
                stack.clear();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParenthesis rOP = new RemoveOutermostParenthesis();
        System.out.println(rOP.removeOuterParentheses("(()())(())"));
        System.out.println(rOP.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(rOP.removeOuterParentheses("()()"));
    }
}
