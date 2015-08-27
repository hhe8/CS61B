import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.*;

public class IteratorExample<T> implements Iterator<T>{
      private Object iterNode;

      private IteratorExample(){
        iterNode = null;
      }

      public boolean hasNext(){
        return false;
      }

      public T next(){
        return null;
      }

      public void remove(){
        throw new UnsupportedOperationException();
      }
}
