interface Generator<T> { T next(); }

public class FibonacciSequence {
     class Sequence implements Generator<Integer> {
     private int seed = 0;
     public Integer next() { return funct(seed++); }
     private int funct(int next) {
         if(next < 2) return 1;
         return funct(next - 2) + funct(next - 1);
     }
   }
}
