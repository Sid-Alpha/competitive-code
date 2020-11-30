package trie;

import javafx.util.Pair;
import utils.info.Garbage;
import utils.info.Question;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/longest-word-in-dictionary/")
@Garbage(why = "Dumb question explanation, the largest string should be such that the substrings of it when removing the last element 1 at a time should be present in the input array")
public class LongestWordinDictionary {

    public String longestWord(String[] words) {
        // Make trie
        Trie trie = new Trie();
        for (String word : words) trie.consume(word);

        // DFS
        return dfs(trie.getRoot());
    }

    private String dfs(Trie.Node node) {
        Stack<Pair<Trie.Node, Pair<String, Boolean>>> stack = new Stack<>();
        stack.push(new Pair<>(node, new Pair<>("", false)));
        String maxStr = "";
        while (!stack.isEmpty()) {
            Pair<Trie.Node, Pair<String, Boolean>> current = stack.pop();
            if (current.getValue().getValue() && current.getValue().getKey().length() + 1 >= maxStr.length())
                maxStr = current.getValue().getKey() + current.getKey().c;
            for (Trie.Node child : current.getKey().getNode()) {
                if (child == null) continue;
                stack.push(new Pair<>(child, new Pair<>(current.getValue().getKey() + current.getKey().c, current.getValue().getValue() || current.getKey().isTerminal())));
            }
        }
        return maxStr.substring(1);
    }

    private class Trie { // lowercase only
        private Node root;

        Trie() { root = new Node('0'); }

        void consume(String s) {
            Node runner = root;
            for(char c : s.toCharArray())
                runner = (runner.at(c) == null ? runner.put(c) : runner.at(c));
            runner.setTerminal();
        }

        public Node getRoot() { return root; }

        private class Node {
            private final Node[] node;
            private final char c;
            boolean terminal;
            public Node at(char c) { return node[c-'a']; }
            public Node put(char c) { return node[c-'a'] = new Node(c); }
            public void setTerminal() { terminal = true; }
            public boolean isTerminal() { return terminal; }
            public Node[] getNode() { return node; }
            public Node(char letter) { node = new Node[26]; c = letter; }
        }
    }

    public static void main(String[] args) {
        LongestWordinDictionary lwd = new LongestWordinDictionary();
        System.out.println(lwd.longestWord(new String[]{"w","wo","wor","worl", "world"})); // world
        System.out.println(lwd.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
        System.out.println(lwd.longestWord(new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"})); // latte
    }
}
