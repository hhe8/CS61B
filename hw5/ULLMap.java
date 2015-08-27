import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.*;

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key.
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */
public class ULLMap<K,V> implements Map61B<K,V>, Iterable<K>{ //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list.
      */
    private int length;
    private Entry front;
    //// constructor
    public ULLMap(){
      front = null;
      length = 0;
    }

    public ULLMap(K key, V val){
      front = new Entry(key,val,null);
      length = 1;
    }

    public static <K,V> ULLMap<V,K> invert(ULLMap<K,V> map){
      ULLMap<V,K> result = new ULLMap<V,K>();
      Iterator<K> iterator = map.iterator();
      K cur = iterator.next();
      while(cur != null){
        result.put(map.get(cur),cur);
        cur = iterator.next();
      }
      return result;
    }

    public Iterator<K> iterator(){
      return new ULLMapIter();
    }

    @Override
    public V get(K key) { //FIX ME
    //FILL ME IN
    if (front == null){
        return null;
      }
      return front.get(key).val; //FIX ME
    }

    @Override
    public void put(K key, V val) { //FIX ME
    //FILL ME IN
      front = new Entry(key,val,front);
      length += 1;
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
    //FILL ME IN
      if (front.get(key) == null){
        return false;
      }
      return true; //FIX ME
    }

    @Override
    public int size() {
        return length; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() {
    //FILL ME IN
      front = null;
      length = 0;
    }


    // private Iterator class
    // note! dont add <K> to the ULLMapIter it will cause compile error
    private class ULLMapIter implements Iterator<K>{

      private Entry iterNode;

      private ULLMapIter(){
        iterNode = front;
      }

      public boolean hasNext(){
        if (iterNode == null){
          return false;
        }
        return true;
      }

      public K next(){
        if (!hasNext()){
          return null;
        }
        K reseult = iterNode.key;
        iterNode = iterNode.next;
        return reseult;
      }

      public void remove(){
        throw new UnsupportedOperationException();
      }

    }

    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {

        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry n) { //FIX ME
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { //FIX ME
            //FILL ME IN (using equals, not ==)
            if(k.equals(key)){
              return this;
            } else if(next != null) {
              return next.get(k);
            }
            return null;
        }

        private K key;
        private V val;
        private Entry next;

    }

    /* Methods below are all challenge problems. Will not be graded in any way.
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }


}
