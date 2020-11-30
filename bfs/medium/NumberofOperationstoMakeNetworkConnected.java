package bfs.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/number-of-operations-to-make-network-connected/")
@UsedHints
@Enhance(details = "Try other algos than dfs")
public class NumberofOperationstoMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;

        List<Integer>[] adjList = new List[n];
        for(int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        for (int[] edge : connections) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            components += dfs(i, adjList, visited);

        return components - 1;
    }

    private int dfs(int n, List<Integer>[] graph, boolean[] visited) {
        if (visited[n]) return 0;
        visited[n] = true;
        for (int node : graph[n]) dfs(node, graph, visited);
        return 1;
    }

    public static void main(String[] args) {
        NumberofOperationstoMakeNetworkConnected nONC = new NumberofOperationstoMakeNetworkConnected();
    }

}
