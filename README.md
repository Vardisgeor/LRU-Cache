# LRU-Cache
Implimatation of a LRU cache memory.

The task concerns the implementation of basic methods for a general-purpose cache memory that follows the 
Least Recently Used (LRU) policy. This memory has a fixed size, and its implementation is done using a doubly 
linked list with a head and a tail. The data is stored along with a key used as a name. For the implementation,
I created a Pair class, which associates the corresponding key and data as a pair for each node in the list. 
Therefore, the list consists of key-data pairs.

Insertion of an element into the cache is done at the head, and extraction is done from the tail. Thus, 
the method store(x, object) adds data along with a key to the end of the list, i.e., at the head. However, 
if the list is full, the LRU policy is followed, meaning that the element visited least recently is deleted, 
and this element is always the tail. Furthermore, the method lookUp(x) searches the cache for an object with 
the key x. If this key exists, the corresponding pair is moved to the head, as it is the most recently 
accessed memory element.

