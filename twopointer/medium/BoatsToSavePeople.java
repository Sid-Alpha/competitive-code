package twopointer.medium;

import utils.info.Enhance;
import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.Stat;

import java.util.Map;
import java.util.TreeMap;

@Question(url = "https://leetcode.com/problems/boats-to-save-people/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE}, details = "Greedy")
@NewAlgo(details = "Greedy", learningSource = "https://leetcode.com/problems/boats-to-save-people/discuss/156855/6-lines-Java-O(nlogn)-code-sorting-%2B-greedy-with-greedy-algorithm-proof.")
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> sortedFatties = new TreeMap<>();
        for (int person : people) sortedFatties.compute(person, (k,v) -> (v == null) ? 1 : (v + 1));
        int rescueBoats = 0;
        Map.Entry<Integer, Integer> firstFatty, secondFatty;

        while (!sortedFatties.isEmpty()) {
            firstFatty = sortedFatties.lastEntry();
            if (firstFatty.getValue() == 1) sortedFatties.remove(firstFatty.getKey());
            else sortedFatties.put(firstFatty.getKey(), firstFatty.getValue() - 1);

            if (!sortedFatties.isEmpty() && limit - firstFatty.getKey() > 0) {
                secondFatty = sortedFatties.floorEntry(limit - firstFatty.getKey());
                if (secondFatty != null)
                    if (secondFatty.getValue() == 1) sortedFatties.remove(secondFatty.getKey());
                    else sortedFatties.put(secondFatty.getKey(), secondFatty.getValue() - 1);
            }
            rescueBoats++;
        }

        return rescueBoats;
    }


    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        System.out.println(boatsToSavePeople.numRescueBoats(new int[] {1,2}, 3)); // 1
        System.out.println(boatsToSavePeople.numRescueBoats(new int[] {3,2,2,1}, 3)); // 3
        System.out.println(boatsToSavePeople.numRescueBoats(new int[] {3,5,3,4}, 5)); // 4
    }

}
