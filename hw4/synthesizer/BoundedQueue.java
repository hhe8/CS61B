package synthesizer;
public interface BoundedQueue{
  int capacity();         // return size of the buffer
  int fillCount();        // return number of items currently in ther buffer
  boolean isEmpty();      // is the buffer empty  (fillCount equals to zero?)
  boolean isFull();       // is the buffer full? (fillCount same as capacity?)
  void enqueue(double x); // add item x to the end
  double dequeue();       // delete and return item from the front
  double peek();          // return (but do not delete) item from the front
}
