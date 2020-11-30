package interview.easy.strings;

import utils.info.Enhance;

@Enhance(details = "reduc e time")
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return  -1;
        int hPtr = 0, nPtr = 0;
        while(hPtr < haystack.length()){
            int ogHptr = hPtr, comparator = hPtr;
            while (hPtr < haystack.length() && haystack.charAt(hPtr++) == needle.charAt(nPtr++)) {
                if(nPtr >= needle.length()) return hPtr - needle.length();
                if(haystack.length()-hPtr >= needle.length() && hPtr < haystack.length() && ogHptr == comparator
                        && haystack.charAt(hPtr) == needle.charAt(0))  ogHptr = hPtr;
            }

//            if(nPtr == needle.length()) return hPtr - needle.length();
            if(comparator != ogHptr) hPtr = ogHptr;
            nPtr = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("mississippi", "a"));
        System.out.println(strStr("mississippi", "issip"));
    }

}
