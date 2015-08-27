import java.util.Iterator;

public class FibonacciAdapterTwo implements Iterable<Integer> {
     int counter;
     FibonacciAdapterTwo(int count) {
         counter = count;
     }
     static class IterableFibonacci implements Iterator<Integer> {
         FibonacciSequence outer = new FibonacciSequence();
         FibonacciSequence.Sequence sequence = outer.new Sequence();
         private int counter;
         public IterableFibonacci(int count) {
             this.counter = count;
         }
         @Override
         public boolean hasNext() { return counter > 0; }
         @Override
         public void remove() {
             throw new UnsupportedOperationException();
         }
         @Override
         public Integer next() {
             counter--;
             return sequence.next();
         }
     };
     public Iterator<Integer> iterator() {
         return new IterableFibonacci(counter);
     }
     public static void main(String[] args) {
         for(Integer next : new FibonacciAdapterTwo(20))
             System.out.print(" " + next);
     }
}
