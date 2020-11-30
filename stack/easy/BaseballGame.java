package stack.easy;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(url = "https://www.youtube.com/watch?v=H74l_Dce3ZM")
@Enhance(reduce = {Stat.TIME, Stat.SPACE}, updated = true)
public class BaseballGame {

    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    s.add(s.peek() + s.elementAt(s.size() - 2));
                    i += s.peek();
                    break;
                case "D":
                    s.add(s.peek() * 2);
                    i += s.peek();
                    break;
                case "C":
                    i -= s.pop();
                    break;
                default:
                    s.add(Integer.parseInt(op));
                    i += s.peek();
                    break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(baseballGame.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
}
