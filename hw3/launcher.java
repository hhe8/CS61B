import static java.lang.System.out;

public class launcher{
  public static void main(String[] args) {
    SortedComparableList a = new SortedComparableList(1,new SortedComparableList(2,new SortedComparableList(3,null)));
    // System.out.println(a);
    // a.insert(2);
    // System.out.println(a);
    //System.out.println(a.get(4));
    SortedComparableList b=new SortedComparableList(a.head,a.tail);
    a.extend(b);
    SortedComparableList c = null;
    a.extend(c);
    System.out.println(a);
    //System.out.println(SortedComparableList.subTail(a,3));
    //System.out.println(SortedComparableList.sublist(a,7,1));
    // SortedComparableList.expungeTail(a,3);
    // System.out.println(a);
    a.squish();
    System.out.println(a);
    a.twin();
    System.out.println(a);
  }
}
