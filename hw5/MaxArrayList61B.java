

public class MaxArrayList61B<E extends Comparable<E>> extends ArrayList61B<E>{
  @Override
  public boolean add(E item){
    if (item.compareTo(get(super.size()-1)) > 0){
      super.add(item);
      return true;
    }
    return false;
  }
}
