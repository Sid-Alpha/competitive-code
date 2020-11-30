package interview.medium.backtracking;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.ArrayList;
import java.util.List;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/")
@Enhance(complexity = Stat.SPACE)
public class GenerateParentheses {
    private static final char[] parenthesis = new char[] {'(',')'};

    public List<String> generateParenthesis(int n) {
        List<String> finalList = new ArrayList<>();
        generateParenthesisHelper(parenthesis , new StringBuilder(), n, n,finalList);
        return finalList;
    }

    private void generateParenthesisHelper(char[] paranthesis, StringBuilder stringBuilder,
                                          int startParCount, int endParCount, List<String> finalList) {
        if(startParCount > endParCount || startParCount < 0)  return;
        if(startParCount == 0 && endParCount == 0) { finalList.add(stringBuilder.toString()); return; }
        for(char c : paranthesis) {
            generateParenthesisHelper(paranthesis, stringBuilder.append(c), (c=='(') ? startParCount-1 : startParCount,
                    (c==')') ? endParCount-1 : endParCount, finalList);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3)); // [((())), (()()), (())(), ()(()), ()()()]
        System.out.println(generateParentheses.generateParenthesis(5));
        System.out.println(generateParentheses.generateParenthesis(7));
        System.out.println(generateParentheses.generateParenthesis(9));
//        System.out.println(generateParentheses.generateParenthesis(11));
//        System.out.println(generateParentheses.generateParenthesis(13));
//        System.out.println(generateParentheses.generateParenthesis(15));

//        RunTimeCompute.compute(() -> generateParentheses.generateParenthesis(7));
//        RunTimeCompute.compute(() -> generateParentheses.generateParenthesis(8));
//        RunTimeCompute.compute(() -> generateParentheses.generateParenthesis(10));
//        RunTimeCompute.compute(() -> generateParentheses.generateParenthesis(15));
//        RunTimeCompute.compute(() -> generateParentheses.generateParenthesis(16));
    }

}
