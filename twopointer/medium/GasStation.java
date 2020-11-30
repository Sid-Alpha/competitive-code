package twopointer.medium;

import utils.info.Question;

@Question(url = "https://leetcode.com/problems/gas-station/")
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, end = 0, totalGas = 0, count = 0;
        while (true) {
            if (start >= cost.length) return -1;

            totalGas += gas[end];
            totalGas -= cost[end];
            end = (end + 1) % cost.length;
            count++;
            while (totalGas < 0 && start < cost.length) {
                totalGas += cost[start];
                totalGas -= gas[start++];
                count--;
            }
            if (count == cost.length) return start;
        }
     }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[] {1,2,3,4,5},
                                                         new int[] {3,4,5,1,2})); // 3
        System.out.println(gasStation.canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3})); // 3
    }
}
