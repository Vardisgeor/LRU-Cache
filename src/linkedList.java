import java.util.NoSuchElementException;

public class linkedList<K,V>{

    private Node<K,V> tail;
    private int size;
    private Node<K,V> head;

    private class Node<K,V>{
        private Pair<K,V> data;
        private Node<K,V> next;
        private Node<K,V> prev;

        Node(Pair<K,V> data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    linkedList(){
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public V look(K key){   // looUp if this key exist in the cache 
        
        if(tail!=null && tail.data.getKey().equals(key)){

            head.next = tail;      // update head and tail
            tail.prev = head;
            head = tail;
            tail = tail.next;
            tail.prev = null;
            head.next = null;
            
            return tail.data.getData();

        }else if(head != null && head.data.key.equals(key)){
               
            return head.data.getData();
            
        }

        Node<K,V> curr = tail;

        while(curr != null){    // find the item with the key and put it in the head
            
            if(curr.data.key.equals(key)){
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                head.next = curr;
                curr.prev = head;
                head = curr;
                curr.next = null;

                return curr.data.getData();
            
            }

            curr = curr.next;
        }
        return null;      
    }

    public void add(Pair<K,V> data){        // add item in the head
        Node<K,V> n = new Node<K,V>(data);
        if(size == 0){  //empty cache
            tail = n;
            head = n;
        }else{
            head.next = n;
            n.prev = head;
            head = n;
        }
      
        size++;
    }
    
    public void remove(){       //remove item from the tail

        if(tail!=null){
            if (tail.equals(head)) {
                tail = null;
                head = null;
            } else {
                tail = tail.next;
                tail.prev = null;
            }
            this.size--; 
        }else{
            throw new NoSuchElementException();
        }
    }  
    
    public int size() {
        return size;
    }
}