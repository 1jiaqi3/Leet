/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

class wNode {
    wNode[] children;
    boolean endOfWord;
    
    public wNode() {
        children = new wNode[26];
        endOfWord = false;
    }
}

public class WordDictionary {
    private wNode root;
    
    public WordDictionary() {
        root = new wNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        wNode runner = root;
        for (int i = 0; i < word.length(); i++) {
            if (runner.children[word.charAt(i) - 'a'] == null) {
                runner.children[word.charAt(i) - 'a'] = new wNode();
            }
            runner = runner.children[word.charAt(i) - 'a'];
        }
        runner.endOfWord = true;        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root, 0);
    }
    
    public boolean search(String word, wNode root, int index) {
        if (root == null) {
            return false;
        }
        if (index == word.length()) {
            return root.endOfWord;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(word, root.children[i], index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, root.children[word.charAt(index) - 'a'], index + 1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
