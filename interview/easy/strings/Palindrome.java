package interview.easy.strings;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) return true;
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : s.toLowerCase().toCharArray())
            if((c >='a' && c <= 'z') || (c >= '0' && c <= '9')) stringBuilder.append(c);

        for(int i = 0, j = stringBuilder.length()-1; i < j;i++, j--)
            if(stringBuilder.charAt(i) != stringBuilder.charAt(j)) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
