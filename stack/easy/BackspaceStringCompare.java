package stack.easy;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(
        url = "https://leetcode.com/problems/backspace-string-compare/",
        followUp = "Can you solve it in O(N) time and O(1) space?"
)
@Enhance(reduce = Stat.TIME, complexity = Stat.SPACE)
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> characterStack = new Stack<>();
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (Character c : S.toCharArray()) {
            if (!characterStack.isEmpty() && c == '#') characterStack.pop();
            else if (c != '#') characterStack.push(c);
        }
        while (!characterStack.isEmpty()) sb1.append(characterStack.pop());
        for (Character c : T.toCharArray()) {
            if (!characterStack.isEmpty() && c == '#') characterStack.pop();
            else if (c != '#')characterStack.push(c);
        }
        while (!characterStack.isEmpty()) sb2.append(characterStack.pop());

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println(bsc.backspaceCompare("ab#c", "ad#c"));
        System.out.println(bsc.backspaceCompare("ab##", "c#d#"));
        System.out.println(bsc.backspaceCompare("a##c", "#a#c"));
        System.out.println(bsc.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
