package twopointer.easy;

import utils.info.Question;
import utils.info.UsedHints;

@Question(url = "https://leetcode.com/problems/long-pressed-name/")
@UsedHints(details = "Edge cases took time")
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (true) {
            if (name.length() == i && typed.length() == j) return true;
            else if (j >= typed.length()) return false;
            else if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++; j++;
            }
            else if (i!=0 && typed.charAt(j) == name.charAt(i-1)) j++;
            else return false;
        }
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex", "aaleex"));    // T
        System.out.println(longPressedName.isLongPressedName("saeed", "ssaaedd"));  // F
        System.out.println(longPressedName.isLongPressedName("leelee", "lleeelee"));    // T
        System.out.println(longPressedName.isLongPressedName("laiden", "laiden"));  // T
        System.out.println(longPressedName.isLongPressedName("vtkgn", "vttkgnn"));  // T
    }
}
