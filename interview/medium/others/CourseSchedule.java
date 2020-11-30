package interview.medium.others;

import utils.info.Question;

import java.util.*;
import java.util.stream.Collectors;

@Question(url = "https://leetcode.com/problems/course-schedule/", details = "White grey black dfs")
public class CourseSchedule {

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, List<Integer>> depMap = new HashMap<>();
//        for(int i = 0; i < numCourses; i++) depMap.put(i, new ArrayList<>());
//        for(int[] link : prerequisites) depMap.get(link[0]).add(link[1]);
//        int[] travelHelper = new int[numCourses];
//
//        for(int i = 0; i < numCourses; i++)
//            if (!dfs(depMap, i, travelHelper)) return false;
//
//        return true;
//    }
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, List<Integer>> depMap = new HashMap<>();
//        HashMap<Integer, Boolean> isStarter = new HashMap<>();
//        for(int i = 0; i < numCourses; i++) depMap.put(i, new ArrayList<>());
//        for(int[] link : prerequisites) {
//            isStarter.put(link[1], false);
//            isStarter.putIfAbsent(link[0], true);
//            depMap.get(link[0]).add(link[1]);
//        }
//        int[] travelHelper = new int[numCourses];
//
//        for(int i = 0; i < numCourses; i++)
//            if (!dfs(depMap, i, travelHelper)) return new int[];
//
//        // loop over starter &
//        List<Integer> starters = isStarter.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toList());
//        boolean[] traversed = new boolean[depMap.size()];
//        List<Integer> solution = new ArrayList<>();
//        for(int i :starters) {
//            if (traversed[i]) continue;
//        }
//    return null;
//    }
//
//    private boolean dfs(HashMap<Integer, List<Integer>> depMap, int node, int[] travelHelper) {
//        if (travelHelper[node] == 1) return false;
//        if (travelHelper[node] == 2) return true;
//        travelHelper[node] = 1;
//        for (Integer nextNode : depMap.get(node))
//            if (!dfs(depMap, nextNode, travelHelper)) return false;
//        travelHelper[node] = 2;
//        return true;
//    }
//
//    public static void main(String[] args) {
//        CourseSchedule cs = new CourseSchedule();
//        System.out.println(cs.canFinish(2, new int[][] {{1,0}}));
//        System.out.println(cs.canFinish(2, new int[][] {{1,0}, {0,1}}));
//        System.out.println(cs.canFinish(3, new int[][] {{0,1}, {0,2}, {1,2}}));
//    }

}
