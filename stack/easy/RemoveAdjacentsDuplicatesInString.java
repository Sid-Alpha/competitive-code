package stack.easy;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/")
@Enhance(reduce = {Stat.TIME}, updated = true)
public class RemoveAdjacentsDuplicatesInString {

    public String removeDuplicates(String S) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : S.toCharArray())
            if (!characterStack.isEmpty() && characterStack.peek().equals(c))
                characterStack.pop();
            else
                characterStack.push(c);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < characterStack.size(); i ++) sb.append(characterStack.elementAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAdjacentsDuplicatesInString removeAdjacentsDuplicatesInString = new RemoveAdjacentsDuplicatesInString();
        System.out.println(removeAdjacentsDuplicatesInString.removeDuplicates("abbaca"));
    }
}
