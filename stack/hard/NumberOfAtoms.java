package stack.hard;

import javafx.util.Pair;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

@Question(url = "https://leetcode.com/problems/number-of-atoms/")
@Enhance(reduce = {Stat.TIME}, complexity = {Stat.TIME}, otherSolutions = {"Recursion", "Regular Expression"})
public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> atomToCount = new TreeMap<>();
        Stack<Pair<String, Integer>> atomStack = new Stack<>();
        Stack<Integer> multiplyHelper = new Stack<>();
        formula = "(" + formula + ")";
        boolean getNum = false;
        StringBuilder number = new StringBuilder(), symbol = new StringBuilder();

        // Parse into stack
        for (int c = 0; c < formula.length(); c ++) {
            // Below is incomplete
            // process
            // if (, start stack pushing || else if ) get the following number & process elements [* with number] till (
            // if capital & buffer empty push to symbol
            // if number then push to number
            // if capital or end of array & symbol is > 0 -> Process the symbol & num (set to 1 if needed)
            // Process -> push to map with num with any multipliers
            if (formula.charAt(c) == ')') {
                if (getNum) {
                    atomStack.push(new Pair<>(")", number.length() == 0 ? 1 : Integer.parseInt(number.toString())));
                    number.setLength(0);
                }
                getNum = true;
                if(c == formula.length() - 1 || !Character.isDigit(formula.charAt(c+1))) {
                    atomStack.push(new Pair<>(")", 1));
                    getNum = false;
                }
            }
            else if (getNum && Character.isDigit(formula.charAt(c))) number.append(formula.charAt(c));
            else if (getNum && !Character.isDigit(formula.charAt(c))) {
                atomStack.push(new Pair<>(")", number.length() == 0 ? 1 : Integer.parseInt(number.toString())));
                number.setLength(0);
                getNum = false;
                c--;
            }
            else if (formula.charAt(c) == '(') atomStack.push(new Pair<>("(", 0));
            else {
                if (Character.isUpperCase(formula.charAt(c))) {
                    if (symbol.length() != 0) {
                        atomStack.push(new Pair<>(symbol.toString(), number.length() == 0 ? 1 : Integer.parseInt(number.toString())));
                        symbol.setLength(0);
                        number.setLength(0);
                    }
                    symbol.append(formula.charAt(c));
                }
                else if (!Character.isDigit(formula.charAt(c))) symbol.append(formula.charAt(c));
                else number.append(formula.charAt(c));

                if (!Character.isDigit(formula.charAt(c+1)) && !Character.isLetter(formula.charAt(c+1)) && symbol.length() > 0) {
                    atomStack.push(new Pair<>(symbol.toString(), number.length() == 0 ? 1 : Integer.parseInt(number.toString())));
                    symbol.setLength(0);
                    number.setLength(0);
                }
            }
        }

        // Process stack
        multiplyHelper.push(atomStack.pop().getValue());
        while (!atomStack.isEmpty()) {
            if (atomStack.peek().getKey().equals("("))
                multiplyHelper.pop();
            else if (atomStack.peek().getKey().equals(")"))
                multiplyHelper.push(atomStack.peek().getValue() * multiplyHelper.peek());
            else
                atomToCount.compute(atomStack.peek().getKey(), (s,n) -> n == null ?
                        atomStack.peek().getValue() * multiplyHelper.peek() : atomStack.peek().getValue() * multiplyHelper.peek() + n);
            atomStack.pop();
        }

        symbol.setLength(0);
        for (Map.Entry<String, Integer> entry : atomToCount.entrySet()) {
            symbol.append(entry.getKey());
            if (entry.getValue() > 1) symbol.append(entry.getValue());
        }
        return symbol.toString();
    }

    public static void main(String[] args) {
        NumberOfAtoms numberOfAtoms = new NumberOfAtoms();
        System.out.println(numberOfAtoms.countOfAtoms("H2O")); // H2O
        System.out.println(numberOfAtoms.countOfAtoms("Mg(OH)2")); // H2MgO2
        System.out.println(numberOfAtoms.countOfAtoms("K4(ON(SO3)2)2")); // K4N2O14S4
    }

}