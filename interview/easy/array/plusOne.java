package interview.easy.array;

import java.util.Arrays;

public class plusOne {
    public static int[] plusOne(int[] digits) {
        int ptr = digits.length-1;
        while(ptr>0) {
            if(digits[ptr] == 9) { digits[ptr] = 0; ptr--; }
            else { digits[ptr]++; break; }
        }
        if(ptr == 0) {
            if(digits[ptr] == 9) {
                digits[ptr] = 0;
                int arr[] = new int[digits.length+1];
                arr[0] = 1;
                System.arraycopy(digits, 0, arr, 1, digits.length);
                return arr;
            }
            else { digits[ptr]++; }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
