/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Return ["eat","oath"].
*/

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, ret, i, j, trie, set, "");
            }
        }
        return ret;
    }
    public void backtracking(char[][] board, List<String> ret, int x, int y, Trie trie, HashSet<String> set, String cur) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 0) {
            return;
        } else {
            cur = cur + board[x][y];
            if (trie.startsWith(cur)) {
                if (trie.search(cur) && !set.contains(cur)) {
                    ret.add(cur);
                    set.add(cur);
                }
                char temp = board[x][y];
                board[x][y] = 0;
                backtracking(board, ret, x - 1, y, trie, set, cur);
                backtracking(board, ret, x + 1, y, trie, set, cur);
                backtracking(board, ret, x, y + 1, trie, set, cur);
                backtracking(board, ret, x, y - 1, trie, set, cur);
                board[x][y] = temp;
            }
        }
    }
}


class TrieNode {
    boolean endOfWord;
    TrieNode[] children;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {
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
