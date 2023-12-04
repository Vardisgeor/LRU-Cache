
class CacheImpl<K,V> implements Cache<K,V>{

    int space;
    int hits = 0;
    int misses = 0;
    linkedList<K,V> list;

    CacheImpl(int space){
        this.space = space;
        this.list = new linkedList<K,V>();
    }

    @Override
    public V lookUp(K key){
        
        if(list.look(key) != null){
            hits++;
            return (V)list.look(key);
        }else{
            misses++;
            return null;
        }
    }

    @Override
    public void store(K x, V value){
        
        if(list.size() == space){
            list.remove();
            list.add(new Pair<K,V>(x,value));
        }else{
            list.add(new Pair<K,V>(x,value));
        }
    }

    @Override
    public double getHitRatio(){
        return (double)hits/(misses+hits);
    }

    @Override
    public long getHits(){
        return hits;
    }

    @Override
    public long getMisses(){
        return misses;
    }

    @Override
    public long getNumberOfLookUps(){
        return misses + hits;
    }

}