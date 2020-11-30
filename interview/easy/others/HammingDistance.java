package interview.easy.others;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int diffs = x^y, count = 0; long twoPower = 1;
        while (twoPower <= diffs) {
            if((twoPower & diffs) > 0) count++;
            twoPower *= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(680142203
                ,1111953568));
    }



}
