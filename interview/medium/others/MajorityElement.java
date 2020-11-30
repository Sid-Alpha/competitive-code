package interview.medium.others;

import utils.info.NewAlgo;
import utils.info.Question;

import java.util.HashMap;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/824/")
@NewAlgo(details = "https://leetcode.com/articles/majority-element/")
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums.length/2;
        HashMap<Integer, Integer> hM = new HashMap<>();
        for(int i : nums) {
            int iC = hM.getOrDefault(i, 0);
            if(iC + 1 > majority) return i;
            hM.put(i, iC+1);
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement mE = new MajorityElement();
        System.out.println(mE.majorityElement(new int[] {3,2,3}));
    }
}
