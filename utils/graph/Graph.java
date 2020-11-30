package utils.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph<N> {
    private final List<GraphNode<N>> nodes;

    public Graph(List<GraphNode<N>> nodes) {
        this.nodes = nodes;
    }

    public List<GraphNode<N>> nodes() { return nodes; }

    @Override
    public String toString() {
        return nodes.stream().map(GraphNode::toString).collect(Collectors.joining("\n"));
    }

    public static class GraphNode<GN> {
        private final GN node;
        private List<GraphNode<GN>> links;

        public GraphNode(GN node) {
            this.node = node;
            links = new ArrayList<>();
        }

        public GN node() { return node; }

        public List<GraphNode<GN>> links() { return links; }

        public void addLink(GraphNode<GN> link) {
            links.add(link);
        }

        @Override
        public String toString() {
            return "Node: " + node + " | Links: " +
                    links.stream().map(n -> n.node.toString()).collect(Collectors.joining(","));
        }
    }
}
