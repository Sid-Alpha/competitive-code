package stack.easy;

import utils.info.Question;

import java.util.ArrayList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/build-an-array-with-stack-operations/")
public class ArrayFromStackOps {

    public List<String> buildArray(int[] target, int n) {
        int count = 0;
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= n ; i++) {
            if (count >= target.length) break;
            else if(target[count] == i) {
                answer.add("Push");
                count++;
            }
            else {
                answer.add("Push");
                answer.add("Pop");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayFromStackOps arrayFromStackOps = new ArrayFromStackOps();
        System.out.println(arrayFromStackOps.buildArray(new int[] {1,3}, 3));
        System.out.println(arrayFromStackOps.buildArray(new int[] {2,3,4}, 4));
        System.out.println(arrayFromStackOps.buildArray(new int[] {2,3,4}, 5));
        System.out.println(arrayFromStackOps.buildArray(new int[] {1,2}, 4));
    }

}