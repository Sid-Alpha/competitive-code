package interview.easy.math;

import utils.info.Enhance;

import java.util.HashMap;
import java.util.Map;

@Enhance(details = "")
public class RomanToInt {
    private static final Map<Character, Integer> romanNumeralsToInt;
    private static final Map<String, Integer> odds;
    static {
        romanNumeralsToInt = new HashMap<>(); odds = new HashMap<>();
        romanNumeralsToInt.put('I',1);
        romanNumeralsToInt.put('V',5);
        romanNumeralsToInt.put('X',10);
        romanNumeralsToInt.put('L',50);
        romanNumeralsToInt.put('C',100);
        romanNumeralsToInt.put('D',500);
        romanNumeralsToInt.put('M',1000);
        odds.put("IV", 4); odds.put("IX", 9);
        odds.put("XL", 40); odds.put("XC", 90);
        odds.put("CD", 400); odds.put("CM", 900);
    }

    public static int romanToInt(String s) {
        if (s.length() == 0) return 0;
        int total = 0, lastNum;
        total += romanNumeralsToInt.get(s.charAt(0));
        lastNum = total;
        for(int i=1; i<s.length(); i++) {
                String str = String.valueOf(s.charAt(i-1)).concat(String.valueOf(s.charAt(i)));
                if(odds.containsKey(str)) {
                    total -= lastNum;
                    lastNum = odds.get(str);
                }
                else lastNum = romanNumeralsToInt.get(s.charAt(i));
                total+=lastNum;
            }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
