package graph.medium;

import utils.info.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/keys-and-rooms/")
public class KeysAndRooms {

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] traversed = new boolean[rooms.size()];
        Queue<Integer> traveller = new LinkedList<>();
        if(rooms != null) traveller.add(0);
        while(!traveller.isEmpty()) {
            int node = traveller.poll();
            if(traversed[node]) continue;
            traversed[node] = true;
            traveller.addAll(rooms.get(node));
        }

        for(boolean t : traversed) if(!t) return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> ll = new ArrayList<>();
        ll.add(new ArrayList<>()); ll.get(0).add(1); ll.get(0).add(3);
        ll.add(new ArrayList<>()); ll.get(1).add(3); ll.get(1).add(0); ll.get(1).add(1);
        ll.add(new ArrayList<>()); ll.get(2).add(2);
        ll.add(new ArrayList<>()); ll.get(3).add(0);

        System.out.println(canVisitAllRooms(ll));

        List<List<Integer>> ll2 = new ArrayList<>();
        ll2.add(new ArrayList<>()); ll2.get(0).add(1);
        ll2.add(new ArrayList<>()); ll2.get(1).add(2);
        ll2.add(new ArrayList<>()); ll2.get(2).add(3);
        ll2.add(new ArrayList<>());

        System.out.println(canVisitAllRooms(ll2));
    }
}
