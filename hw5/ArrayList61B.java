import java.util.*;
public class ArrayList61B<E> extends AbstractList<E>{

  private int capacity;
  private int size;
  private E[] iArray;

  public ArrayList61B(int initialCapacity){
    if (initialCapacity < 1){
      throw new IllegalArgumentException();
    }
    capacity = initialCapacity;
    iArray = (E []) new Object[capacity];
    size = 0;
  }

  public ArrayList61B(){
    capacity = 1;
    iArray = (E []) new Object[capacity];
    size = 0;
  }

  public E get(int i){
    if (i < 0 || i >= size){
      throw new IllegalArgumentException();
    }
    return iArray[i];
  }

  public boolean add(E item){
    if (size == capacity){
      resize();
    }
    iArray[size] = item;
    size += 1;
    return true;
  }

  private void resize(){
    capacity = capacity + capacity;
    E[] newArray = (E[]) new Object[capacity];
    for (int i = 0; i < size; i+= 1){
      newArray[i] = iArray[i];
    }
    iArray = newArray;
  }

  public int size(){
    return size;
  }
}
