package HW4;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Driver class that generates stats on various data structures for storing a dictionary.
 * 
 *   @author Sherri Weitl Harms and Dave Reed | Modified by Jerome Bustarga
 *   @version 11/07/24
 */

public class StatsDriver {
    public static void main(String[] args) throws java.io.FileNotFoundException {

        // ArrayList
        ArrayList<String> wordsAL = new ArrayList<>();
        runMe(wordsAL, "dictionary.txt");

        // LinkedList
        LinkedList<String> wordsLinked = new LinkedList<>();
        runMe(wordsLinked, "dictionary.txt");

        // TreeSet
        TreeSet<String> wordsTree = new TreeSet<>();
        runMe(wordsTree, "dictionary.txt");

        // Trie
        Trie trie = new Trie();
        runMe(trie, "dictionary.txt");
    }

    public static void runMe(Collection<String> words, String filename) throws java.io.FileNotFoundException {
        Scanner input = new Scanner(new File(filename));

        long beforeMemory = Runtime.getRuntime().freeMemory();
        while (input.hasNext()) {
            words.add(input.next());
        }
        long afterMemory = Runtime.getRuntime().freeMemory();

        if (words instanceof ArrayList) System.out.println("ArrayList");
        else if (words instanceof LinkedList) System.out.println("LinkedList");
        else if (words instanceof TreeSet) System.out.println("TreeSet");

        System.out.println("Memory used (MB): " + (beforeMemory - afterMemory) / 1e6);
        
        input.close();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            words.contains("zyzzyvas");
            words.contains("zzzzzzzz");
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("Search time (sec): " + (endTime - startTime) / 1e3);
    }

   
    public static void runMe(Trie trie, String filename) throws java.io.FileNotFoundException {
        Scanner input = new Scanner(new File(filename));

        long beforeMemory = Runtime.getRuntime().freeMemory();
        
        while (input.hasNext()) {
            trie.addWord(input.next());  
        }
        
        long afterMemory = Runtime.getRuntime().freeMemory();

        System.out.println("Trie");
        
        System.out.println("Memory used (MB): " + (beforeMemory - afterMemory) / 1e6);
        
        input.close();

        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            trie.isWord("zyzzyvas");  
            trie.isWord("zzzzzzzz");  
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Search time (sec): " + (endTime - startTime) / 1e3);
    }
}
