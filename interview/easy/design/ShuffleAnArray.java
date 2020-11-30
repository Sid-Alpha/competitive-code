package interview.easy.design;

import utils.info.NewAlgo;
import utils.info.Unfinished;
import utils.info.UsedHints;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@UsedHints
@Unfinished
@NewAlgo(details = "Fisher-Yates Shuffle Algorithm")
public class ShuffleAnArray {
    public final int[] initialArray;
    private int[][] state;
    public ShuffleAnArray(int[] nums) {
        Random r = new Random();
        this.initialArray = nums;
        state = new int[nums.length][nums.length];

    }

    private void stateGen(int [][] state, List<Integer> list, int curr) {
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return initialArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        return initialArray;
    }

    public static void main(String[] args) {
        ShuffleAnArray sf = new ShuffleAnArray(new int[]{1,2,3,45});
        System.out.println(Arrays.toString(sf.shuffle()));
        System.out.println(Arrays.toString(sf.shuffle()));
        System.out.println(Arrays.toString(sf.shuffle()));
        System.out.println(Arrays.toString(sf.shuffle()));
        System.out.println(Arrays.toString(sf.shuffle()));
        System.out.println(Arrays.toString(sf.reset()));
    }
}
