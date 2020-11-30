package hashtable.easy;

import utils.info.Question;

import java.util.HashSet;

@Question(url = "https://leetcode.com/problems/jewels-and-stones/")
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) jewels.add(J.charAt(i));
        int num = 0;
        for (int i = 0; i < S.length(); i++) if (jewels.contains(S.charAt(i))) num++;
        return num;
    }

    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(jewelsAndStones.numJewelsInStones("z", "ZZ"));
    }

}
