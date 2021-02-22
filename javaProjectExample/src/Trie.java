import java.util.HashMap;

/**
 * TrieNode
 */
class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isEnd;

    TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

public class Trie {
    /** Initialize your data structure here. */
    private TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = this.root;
        for (Character character : word.toCharArray()) {
            if (current.children.get(character) != null) {
                current = current.children.get(character);
            } else {
                current.children.put(character, new TrieNode());
                current = current.children.get(character);
            }
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = this.root;
        for (Character character : word.toCharArray()) {
            if (current.children.get(character) != null) {
                current = current.children.get(character);
            } else {
                return false;
            }
        }
        return current.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for (Character character : prefix.toCharArray()) {
            if (current.children.get(character) != null) {
                current = current.children.get(character);
            } else {
                return false;
            }

        }
        return true;
    }
}
