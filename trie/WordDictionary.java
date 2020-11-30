package trie;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

@Question(url = "https://leetcode.com/problems/design-add-and-search-words-data-structure/")
@Enhance(complexity = {Stat.SPACE, Stat.TIME})
public class WordDictionary {
    private final Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray())
            node = node.addAndReturn(c);
        node.setTerminal(word.charAt(word.length()-1));
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node node, String word) {
        if (node == null) return false;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c  == '.') {
                for(int j = 0; j < 26; j++) {
                    if (i == word.length() - 1)
                        if (node.charMatch((char) (97 + j)) != null && node.charMatch((char) (97 + j)).isTerminal((char) (97 + j))) return true;
                        else continue;
                    else if (search(node.charMatch((char) (97 + j)), word.substring(i+1))) return true;
                }
                return false;
            }

            node = node.charMatch(c);
            if (node == null) return false;
        }
        return (node.isTerminal(word.charAt(word.length()-1)));
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

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.search("pad")); // return False
//        System.out.println(wordDictionary.search("bad")); // return True
//        System.out.println(wordDictionary.search(".ad")); // return True
//        System.out.println(wordDictionary.search("b..")); // return True

        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }

}
