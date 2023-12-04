
public class Pair<K,V>{
    public K key;
    public V data;

    Pair(K key, V data){    //pair with a key and a value
        this.key = key;
        this.data = data;
    }

    public K getKey(){
        return key;
    }

    public V getData(){
        return data;
    }
}