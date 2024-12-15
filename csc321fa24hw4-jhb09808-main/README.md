[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/6Z9nfRZQ)

Memory vs. Speed

In class, we have discussed the tradeoffs between several data structures for storing collections of values. The provided StatsDriver program prints statistics on collections storing a dictionary of 117,663 words. As is, it displays how many megabytes are required to store the dictionary in an ArrayList and how many seconds it takes to do a large number of searches on that ArrayList, as well as a LinkedList and a TreeSet. Execute this program and report the sizes and times for all three data structures. Based on what we know about the data structures, do the relative sizes and times make sense? Explain your answers.

![image](https://github.com/user-attachments/assets/2d4d9a86-99a4-4b3b-bcec-fe6b53bb6b9c)

Memory Usage:

•	ArrayList: The memory usage is moderate, which is expected. ArrayList stores elements in a contiguous block of memory, which is efficient for storage.

•	LinkedList: It uses significantly more memory than ArrayList. This aligns with our understanding of LinkedList, where each element requires additional memory for storing references to the next (and possibly previous) elements.

•	TreeSet: The negative value (-6.97536 MB) is unexpected and likely due to how memory measurement is implemented in the Java runtime. It's possible that the TreeSet implementation is more memory-efficient than anticipated, or there might be some memory optimization or garbage collection occurring during the measurement.

Search Times:

•	ArrayList: The search time is moderate. ArrayList has O(n) search time for unsorted data, which explains why it's slower than TreeSet but faster than LinkedList.

•	LinkedList: It has the slowest search time by far. This is expected because LinkedList requires sequential traversal for searches, resulting in O(n) time complexity.

•	TreeSet: It demonstrates the fastest search time. This aligns with our understanding of TreeSet, which is typically implemented as a Red-Black tree, offering O(log n) search time.

Conclusion:

The relative sizes and times generally make sense based on what we know about these data structures, with a few considerations:

1.	ArrayList offers a good balance between memory usage and search time, which is why it's often a default choice for many applications.
2.	LinkedList shows poor performance in both memory usage and search time for this specific use case. It's better suited for scenarios with frequent insertions and deletions in the middle of the list.
3.	TreeSet demonstrates excellent search performance, which is its primary strength. The memory usage result is anomalous and would require further investigation to understand fully.


Trie Stats

The tradeoffs between tries and the other data structures we have studied are significant. You might expect a trie to require significantly more space, since each node essentially stores only one letter and has 26 potential references. However, structure sharing can offset this cost. For example, storing "fool" requires no additional storage if you have already stored "foolish". Searching a trie should be much faster, as search is independent of the number of words stored and only dependent on the length of the sequence being search for. Modify the StatsDriver class to generate stats on a trie storing the dictionary. Report your stats and discuss whether they meet your expectations when compared with the previous data structures.

![image](https://github.com/user-attachments/assets/26af8d79-0d08-4190-993a-3dc1aaada48f)

The performance statistics for the trie implementation compared to other data structures reveal some interesting insights. In terms of memory usage, the trie consumes about 13.72 MB, which falls between the ArrayList (9.98 MB) and LinkedList (54.52 MB), while using more memory than the TreeSet (which shows an unusual negative value of -6.32 MB). This memory efficiency aligns with expectations, as tries can optimize storage through prefix sharing, especially for dictionaries with numerous common prefixes. 

The trie's search time of 0.004 seconds is remarkably fast, significantly outperforming the ArrayList (16.909 seconds), LinkedList (188.616 seconds), and even the TreeSet (0.017 seconds). This exceptional search performance is a key advantage of tries, reflecting their O(k) time complexity for word searches, where k is the length of the word, regardless of the total number of stored words. The results largely meet expectations, with the trie using more memory than a simple ArrayList but less than a LinkedList, as anticipated. Its search performance is exceptionally good, even surpassing expectations by outperforming the TreeSet. 

The trie demonstrates a favorable balance between memory usage and search speed, justifying the slight increase in memory compared to an ArrayList with its dramatic improvement in search time. For applications prioritizing fast string searches or prefix matching, the trie proves to be an excellent choice among the compared data structures, showcasing its potential for further optimization through compression techniques.





