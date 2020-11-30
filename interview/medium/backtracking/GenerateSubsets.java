package interview.medium.backtracking;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Question(url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/109/backtracking/796/")
@UsedHints
@Enhance(details = "TODO Learn subset generation & use other techniques")
public class GenerateSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());

        for(int num : nums) {
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> l : list)
                newList.add(new ArrayList<Integer>(l) {{add(num);}});
            list.addAll(newList);
        }

        return list;
    }

    public static void main(String[] args) {
        GenerateSubsets generateSubsets = new GenerateSubsets();
        System.out.println(generateSubsets.subsets(new int[] {1, 2, 3}));
    }
}
