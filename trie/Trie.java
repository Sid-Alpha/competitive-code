package trie;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

@Question(url = "https://leetcode.com/problems/implement-trie-prefix-tree/submissions/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class Trie {

    private final Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray())
            node = node.addAndReturn(c);
        node.setTerminal(word.charAt(word.length()-1));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            node = node.charMatch(c);
            if (node == null) return false;
        }
        return (node.isTerminal(word.charAt(word.length()-1)));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()) {
            node = node.charMatch(c);
            if (node == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    private class Node {
        Node[] node;
        boolean[] isTerminal;
        Node() {
            this.node = new Node[26];
            this.isTerminal = new boolean[26];
        }

        Node addAndReturn(char c) {
            if(node[c-'a'] != null) return node[c-'a'];
            return node[c-'a'] = new Node();
        }

        void setTerminal(char c) {
            isTerminal[c-'a'] = true;
        }

        boolean isTerminal(char c) {
            return isTerminal[c-'a'];
        }

        Node charMatch(char c) {
            return node[c-'a'];
        }
    }

}
