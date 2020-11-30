package interview.hard;

import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.Unfinished;

@Question(url = "https://leetcode.com/problems/trapping-rain-water/description/")
@NewAlgo(details = "Lower envelope, min max/max min",
        learningSource = "https://www.youtube.com/watch?v=XqTBrQYYUcc")
@Unfinished
public class TrappingRainWater {

    public int trap(int[] height) {
        return -1;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
