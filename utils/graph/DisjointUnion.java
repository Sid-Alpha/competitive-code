package utils.graph;

import java.util.Arrays;

public class DisjointUnion {
    private int[] parent, rank;

    public DisjointUnion(int count) {
        parent = new int[count+1];
        for(int i = 0; i <= count; i++) parent[i] = i;
        rank = new int[count+1];
    }

    public boolean union(int x, int y) {
        int i = find(x), j = find(y);
        if(i == j) return false;
        if(rank[i] >= rank[j]) {
            parent[j] = i;
            rank[i] += rank[j];
        }
        else {
            parent[i] = j;
            rank[j] += rank[i];
        }
        return true;
    }

    public int find(int e) {
        if(parent[e] != e) parent[e] = find(parent[e]);
        return parent[e];
    }

    public int[] showParent() {
        return Arrays.copyOf(parent, parent.length);
    }

    public static void main(String[] args) {
        DisjointUnion dsu = new DisjointUnion(5);
        dsu.union(1,2);
        dsu.union(2, 3);

        dsu.union(4,5);
        System.out.println(Arrays.toString(dsu.parent));
        dsu.union(1,5);
        System.out.println(Arrays.toString(dsu.parent));
    }

}
