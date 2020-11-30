package stack.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/")
@Enhance(reduce = {Stat.TIME})
public class ValidStringAfterSubstitution {

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (characterStack.size() >= 2 && c == 'c' && characterStack.peek() == 'b' && characterStack.elementAt(characterStack.size() -2) == 'a') {
                characterStack.pop();
                characterStack.pop();
                continue;
            }

            characterStack.push(c);
        }

        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidStringAfterSubstitution vsas = new ValidStringAfterSubstitution();
        System.out.println(vsas.isValid("aabcbc")); // T
        System.out.println(vsas.isValid("abcabcababcc")); // T
        System.out.println(vsas.isValid("abccba")); // F
        System.out.println(vsas.isValid("cababc")); // F
    }

}
