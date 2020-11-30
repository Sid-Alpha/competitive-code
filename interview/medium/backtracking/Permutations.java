package interview.medium.backtracking;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        permutationHelper(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), permutations);

        return permutations;
    }

    private void permutationHelper(List<Integer> remainingNumbers, List<Integer> currentList, List<List<Integer>> permutations) {
        if(remainingNumbers.size() == 0) {
            permutations.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < remainingNumbers.size(); i++) {
            int numberToAdd = remainingNumbers.get(i);
            remainingNumbers.remove(i);
            currentList.add(numberToAdd);
            permutationHelper(remainingNumbers, currentList, permutations);
            currentList.remove(currentList.size()-1);
            remainingNumbers.add(i, numberToAdd);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[] {1, 2, 3}));
    }
}
