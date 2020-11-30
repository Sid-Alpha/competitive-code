package examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.IntStream.range;

public class StringRev {
    char temp;

    public void reverseString(char[] s) {
        strRev(0, s);
        System.out.println(s);
    }

    public void strRev(int i, char[] s){
        if(i>=(s.length-i-1)) return;
        temp = s[i];
        s[i] = s[s.length-i-1];
        s[s.length-i-1] = temp;
        strRev(i+1, s);
    }

    public static void main(String[] args) {
//        char[] s = {'H', 'E', 'L', 'L', 'O'};
//        new StringRev().reverseString(s);
//        System.out.println(kthGrammar(4, 6));

        System.out.println(generateTrees(3));
    }

    public static int kthGrammar(int N, int K) {
        if(N==1 || (N==2 && K==1)) return 0;
        if(N == 2 && K ==2) return 1;
        System.out.println("N: "+N+" K: "+K+" POW:" + Math.pow(2, N-2));
        if(K<= Math.pow(2, N-2)) {
            return kthGrammar(N-1, K);
        }
        else return reverse(kthGrammar(N, K - (int)(Math.pow(2, N-2) )));
    }

    List<TreeNode> finalList = new ArrayList<>();

    public static List<TreeNode> generateTrees(int n) {
        return gen(1, n);
    }

    private static List<TreeNode> gen(int s, int e) {
        List<TreeNode> list = new ArrayList<>();
        if(s > e) {
            list.add(null); return list;
        }

        for(int i=s;i<=e;i++){

            for(TreeNode l : gen(s, i-1))
                for(TreeNode r: gen(i+1, e)) {
                    TreeNode  node = new TreeNode(i);
                    node.left = l;
                    node.right = r;

                    list.add(node);
                }
        }
        return list;
    }

        private static int reverse(int i) {
        if(i == 0) return 1;
        return 0;
    }

    static HashMap<Integer, Integer> m = new HashMap<>();
    private static int fib(int n) {
        m.clear();
        if(m.containsKey(n)) return m.get(n);
        int result = 0;
        if(n<2) result = n;
        result = fib(n-1) + fib(n-2);
        m.put(n, result);
        return result;
    }

    public static double myPow(double x, int n) {
        System.out.println("n:" + n);
        if(n==0) return 1;
        double temp = myPow(x, n/2);
        if(n%2 == 0)
            return temp * temp;
        else {
            if(n > 0) return x * temp * temp;
            else return temp * temp / x;
        }
    }

    private static int climbStairs(int n) {
        m.clear();
        if(m.containsKey(n)) return m.get(n);
        if(n<=2) return n;
        m.put(n, climbStairs(n-1) + climbStairs(n-2));

        return m.get(n);
    }


    static int[] ss = new int[30000];
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> li = new ArrayList<>();
        for(int i: range(0,rowIndex + 1).toArray()) {
            li.add(compute(i, rowIndex));
        }
        return li;
    }

    private static int compute(int i, int j) {
        if(ss[i*50+j]!=0) return ss[i*50+j];
        if(i==0 || j==i) return 1;
        return ss[i*50+j] = compute(i-1, j-1) + compute(i, j-1);
    }

     private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.valueOf(val);
         }
     }

}
