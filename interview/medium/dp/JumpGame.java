package interview.medium.dp;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/111/dynamic-programming/807/")
@UsedHints
@Enhance(details = "Don't use DP (I know wtf indeed)")
public class JumpGame {
    enum Index {
        REACHABLE, NONREACHABLE, IDK
    }

    public boolean canJump(int[] nums) {
        Index[] jumpInfo = new Index[nums.length];
        Arrays.fill(jumpInfo, Index.IDK);
        jumpInfo[nums.length-1] = Index.REACHABLE;
        return jumpHelper(nums, 0, nums.length - 1, jumpInfo);
    }

    private boolean jumpHelper(final int[] nums, int position, int finalPosition, Index[] jumpInfo) {
        if(jumpInfo[position]!= Index.IDK) return jumpInfo[position] == Index.REACHABLE;

        for(int jumpLength = nums[position]; jumpLength >= 1; jumpLength--)
            if((position + jumpLength <= finalPosition) &&
                    jumpHelper(nums, position + jumpLength, finalPosition, jumpInfo)) {
            jumpInfo[position] = Index.REACHABLE;
            return true;
            }

        jumpInfo[position] = Index.NONREACHABLE;
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();

        System.out.println(jumpGame.canJump(new int[] { 2,3,1,1,4 })); // true
        System.out.println(jumpGame.canJump(new int[] { 3,2,1,0,4 })); // false

    }
}
