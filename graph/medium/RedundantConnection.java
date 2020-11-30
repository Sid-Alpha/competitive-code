package graph.medium;

import utils.graph.DisjointUnion;
import utils.info.Enhance;
import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Question(url = "https://leetcode.com/problems/redundant-connection/")
@NewAlgo(details = "UnionFind")
@UsedHints
@Enhance(details = "TIme complexity")
public class RedundantConnection {

    public static int[] findRedundantConnectionDFS(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] traversed = new boolean[1001];
        for(int[] edge : edges) {
            Arrays.fill(traversed, false);
            if(adjList.containsKey(edge[0]) && adjList.containsKey(edge[1]) &&
                    canConnectAlready(edge[0], edge[1], adjList, traversed)) return edge;

            if(adjList.containsKey(edge[0])) adjList.get(edge[0]).add(edge[1]); else adjList.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            if(adjList.containsKey(edge[1])) adjList.get(edge[1]).add(edge[0]); else adjList.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
        }

        throw new RuntimeException("No solution for this input");
    }

    private static boolean canConnectAlready(int node, int endNode, Map<Integer, List<Integer>> adjList, boolean[] traversed) {
        if(!traversed[node]) {
            traversed[node] = true;
            if(node == endNode) return true;
            for(int destNode: adjList.get(node))
                if(canConnectAlready(destNode, endNode, adjList, traversed)) return true;
        }
        return false;
    }

    public static int[] findRedundantConnectionDisjointUnion(int[][] edges) {
        DisjointUnion dsu = new DisjointUnion(1001);

        for (int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) return edge;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnectionDFS(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
        System.out.println(Arrays.toString(findRedundantConnectionDisjointUnion(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

}
