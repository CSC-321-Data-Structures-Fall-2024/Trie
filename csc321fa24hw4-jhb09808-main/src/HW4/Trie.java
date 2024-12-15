package HW4;

/**
 * Trie class that represents a Trie (prefix tree) data structure for storing words.
 * Each node in the Trie represents a letter, and paths from the root to nodes represent words or prefixes.
 * This Trie supports adding words, checking if a sequence is a valid word, and checking if a sequence is a prefix.
 * 
 * The Trie is case-insensitive, meaning "foo" and "Foo" are treated as the same word.
 * 
 * Example of stored words: A, ARM, ART, I, IS, THE (as shown in the provided diagram).
 * 
 * @author Jerome Bustarga
 * @version 11/02/24
 */
public class Trie {

    
    private class TrieNode {
        boolean isWord;  
        TrieNode[] children;  

        /**
         * Constructor for TrieNode.
         * Initializes the node with no children and sets isWord to false.
         */
        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];  
        }
    }

    private TrieNode root;  

    /**
     * Constructor for the Trie.
     * Initializes an empty Trie with only the root node.
     */
    public Trie() {
        root = new TrieNode(); 
    }

    /**
     * Adds a word to the Trie.
     * This method inserts the given word into the Trie, creating new nodes as necessary.
     * It is case-insensitive, so all words are converted to lowercase before insertion.
     *
     * @param word The word to be added to the Trie.
     */
    public void addWord(String word) {
        word = word.toLowerCase();  
        TrieNode current = root;  

        
        for (char c : word.toCharArray()) {
            int index = c - 'a'; 

          
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isWord = true;  
    }

    /**
     * Checks if a given sequence is a valid word stored in the Trie.
     *
     * @param word The sequence to check.
     * @return true if the sequence is a valid word in the Trie, false otherwise.
     */
    public boolean isWord(String word) {
        word = word.toLowerCase(); 
        TrieNode current = root;  

      
        for (char c : word.toCharArray()) {
            int index = c - 'a';  

            
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index]; 
        }

        return current.isWord;  
    }

    /**
     * Checks if a given sequence is a prefix of any valid words stored in the Trie.
     *
     * @param prefix The sequence to check as a prefix.
     * @return true if the sequence is a prefix of any words in the Trie, false otherwise.
     */
    public boolean isPrefix(String prefix) {
        prefix = prefix.toLowerCase(); 
        TrieNode current = root;  

       
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';  

            
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index]; 
        }

        return true; 
    }
}
