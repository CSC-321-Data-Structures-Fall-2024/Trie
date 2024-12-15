package HW4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * TrieDriver class to test the Trie data structure.
 * This driver reads words from a dictionary file, stores them in a Trie, and allows the user to check if sequences are either valid words or prefixes.
 * 
 * The Trie stores words such as "A", "ARM", "ART", "I", "IS", and "THE" as shown in the provided diagram.
 * 
 * Example interaction:
 * Enter a sequence (blank line to end): arm
 *   arm is a word.
 * Enter again: ar
 *   arn is not a word, but it is a prefix of a word.
 * Enter again: zzz
 *   zzz is neither a word nor a prefix.
 * Enter again:
 *   DONE
 * 
 * @author Jerome Bustarga
 * @version 11/02/24
 */
public class TrieDriver {

    public static void main(String[] args) throws FileNotFoundException {
        
        Trie trie = new Trie();

       
        Scanner fileScanner = new Scanner(new File("dictionary.txt"));
        
        while (fileScanner.hasNext()) {
            String word = fileScanner.next();
            trie.addWord(word);  
        }
        
        fileScanner.close();

      
        Scanner inputScanner = new Scanner(System.in);
        
        boolean firstPrompt = true; 
        
        while (true) {
            if (firstPrompt) {
                System.out.print("Enter a sequence (blank line to end): ");
                firstPrompt = false;
            } else {
                System.out.print("Enter again: ");
            }
            
            String sequence = inputScanner.nextLine().trim(); 

            if (sequence.isEmpty()) {
                break;  
            }

            
            if (trie.isWord(sequence)) {
                System.out.println("  " + sequence + " is a word.");
            } else if (trie.isPrefix(sequence)) {
                System.out.println("  " + sequence + " is not a word, but it is a prefix of a word.");
            } else {
                System.out.println("  " + sequence + " is neither a word nor a prefix.");
            }
        }
        
        System.out.println("  DONE"); 
        
        inputScanner.close();  
    }
}
