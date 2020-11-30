package other.medium;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@Question(url = "https://leetcode.com/problems/avoid-flood-in-the-city/")
@UsedHints
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class AvoidFloodInTheCity {

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lakeToLastFilled = new HashMap<>();
        TreeSet<Integer> freeDays = new TreeSet<>();
        int[] answer = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                freeDays.add(i);
                answer[i] = 666;
            }
            else {
                if (lakeToLastFilled.containsKey(lake)) {
                    Integer fillAvail = freeDays.higher(lakeToLastFilled.get(lake));
                    if (fillAvail == null) return new int[] {}; // cant fill
                    answer[fillAvail] = lake;
                    freeDays.remove(fillAvail);
                }
                lakeToLastFilled.put(lake, i);
                answer[i] = -1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        AvoidFloodInTheCity avoidFloodInTheCity = new AvoidFloodInTheCity();
        System.out.println(Arrays.toString(avoidFloodInTheCity.avoidFlood(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(avoidFloodInTheCity.avoidFlood(new int[]{1,2,0,0,2,1})));
        System.out.println(Arrays.toString(avoidFloodInTheCity.avoidFlood(new int[]{69,0,0,0,69})));
    }

}
