package utils.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

import static java.lang.Math.min;

public class Djisktra {

    private static class Node<N, W extends Comparable> implements Comparable<Node<N ,W>>{
        final N node;
        final W weight;

        Node(N node, W weight) {
            this.node = node;
            this.weight = weight;
        }

        static<N, W extends Comparable> Node node(N node, W weight) {
            return new Node<>(node, weight);
        }

        @Override
        public int compareTo(Node<N, W> o) {
            return weight.compareTo(o.weight);
        }
    }

    public static int[] shortestPathAdjMatrix(int[][] graph, int startNode) {
        boolean[] isProcessed = new boolean[graph.length];
        PriorityQueue<Node<Integer, Integer>> priorityQueue = new PriorityQueue<>(); // Should be for weight
        int[] weights = new int[graph.length];
        Arrays.fill(weights, Integer.MAX_VALUE);

        priorityQueue.add(new Node<>(0, 0));
        weights[startNode] = 0;

        while (!priorityQueue.isEmpty()) {
            Node<Integer, Integer> currentNode = priorityQueue.poll();

            if (isProcessed[currentNode.node]) continue;
            isProcessed[currentNode.node] = true;

            for (int i = 0; i < graph.length; i++) {
                if ((graph[currentNode.node][i] == 0 && graph[i][currentNode.node] == 0) || isProcessed[i] || currentNode.node == i) continue;
                weights[i] = min(weights[i], weights[currentNode.node] + graph[currentNode.node][i]);
                priorityQueue.add(new Node<>(i, weights[i]));
            }
        }

        return weights;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestPathAdjMatrix(new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}}, 0)))
        ;

    }
}
