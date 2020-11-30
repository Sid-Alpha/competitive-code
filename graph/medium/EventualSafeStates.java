package graph.medium;

import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.ArrayList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/find-eventual-safe-states/")
@UsedHints
@NewAlgo(details = "White grey black DFS")
public class EventualSafeStates {

    enum DFSState {
        WHITE(false), BLACK(false), GREY(true);

        final boolean loop;
        DFSState(boolean loop) { this.loop = loop;}
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
//        DFSState[] nodeStates = new DFSState[graph.length];
//        Arrays.fill(nodeStates, DFSState.WHITE);  // Takes an extra 1ms
        int[] nodeStates = new int[graph.length];

        List<Integer> safeNodes = new ArrayList<>();
        for (int node = 0; node < graph.length; node++) {
            if(dfs(node, graph, nodeStates)) safeNodes.add(node);
        }

        return safeNodes ;
    }

    private static boolean dfs(int node, int[][] graph, int[] states) {
        states[node] = 1;

        for(int endNode : graph[node]) {
            if(states[endNode] == 2) continue;
            if(states[endNode] == 1 || !dfs(endNode, graph, states)) return false;
        }
        states[node] = 2;
        return true;
    }
//    public static List<Integer> eventualSafeNodes(int[][] graph) {
//        boolean[] isSafe = new boolean[graph.length], isComputed = new boolean[graph.length], traversed = new boolean[graph.length];
//        Arrays.fill(isSafe, true);
//
//        for(int node = 0; node < graph.length; node++) {
//            Arrays.fill(traversed, false);
//            dfsSafe(node, graph, isSafe, isComputed, traversed);
//        }
//        List<Integer> safeNodes = new ArrayList<>();
//        for (int i = 0; i < isSafe.length; i++)
//            if(isSafe[i]) safeNodes.add(i);
//
//        return safeNodes;
//    }

//    private static boolean dfsSafe(int node, int[][] graph, boolean[] isSafe, boolean[] isComputed, boolean[] traversed) {
//        if(traversed[node]) {
//            if(isComputed[node])return isSafe[node];
//            if(!isComputed[node]) {
//                isComputed[node] = true;
//                return isSafe[node] = false;
//            }
//        }
//
//        traversed[node] = true;
//        if(isComputed[node]) return isSafe[node];
//        if(graph[node].length != 0) {
//            for (int endNode : graph[node])
//                if (!dfsSafe(endNode, graph, isSafe, isComputed, traversed)) {
//                    isComputed[node] = true;
//                    return isSafe[node] = false;
//                }
//        }
//        isComputed[node] = true;
//        return isSafe[node] = true;
//    }

    public static void main(String[] args) {
        int[][] graph1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph1));

        int[][] graph2 = {{},{0,2,3,4},{3},{4},{}};
        System.out.println(eventualSafeNodes(graph2));
    }

}
