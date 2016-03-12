/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/
class TrieNode {
    boolean endOfWord;
    TrieNode[] children;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode runner = root;
        for (int i = 0; i < word.length(); i++) {
            if (runner.children[word.charAt(i) - 'a'] == null) {
                runner.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            runner = runner.children[word.charAt(i) - 'a'];
        }
        runner.endOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode runner = root;
        for (int i = 0; i < word.length(); i++) {
            if (runner.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            runner = runner.children[word.charAt(i) - 'a'];
        }
        return runner.endOfWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (runner.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            runner = runner.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
