package interview.easy.array;

import utils.info.Enhance;
import utils.info.UsedHints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@UsedHints
@Enhance(details = "reduce run time")
public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] op = new int[2];
        for(int i = 0; i < nums.length ; i++) map.put(target - nums[i], i);
        for(int i = 0; i < nums.length ; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) { // && map.get(nums[i]) != i
                op[0] = map.get(nums[i]);
                op[1] = i;
            }
        }
        System.out.println(map);
        return op;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }
}
