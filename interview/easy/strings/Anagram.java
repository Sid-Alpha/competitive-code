package interview.easy.strings;

public class Anagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] cA = new int[256];
        for(char c : s.toCharArray()) {
            cA[c]++;
        }
        for(char c : t.toCharArray()) {
            cA[c]--;
        }
        for(int i:cA) {
            if(i!=0) return false;
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("lkh", "lhk"));
        System.out.println(isAnagram("kjh", "jklh"));

    }
}
