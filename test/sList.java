public class sList{
    public intList front;
    public intList sentinel;
    public intList backSentinel;
    public int size = 0;

    public sList(){
        front = null;
        sentinel = new intList(4321,front);
        backSentinel = null;
    }

    public sList(int x){
        front = new intList(x,null);
        sentinel = new intList(123,front);
        backSentinel = new intList(4321,front);
    }

    public void insertFront(int x){
        front = new intList(x,front);
        size += 1;
        if (size == 1){
            backSentinel = new intList(431,front);
        }
    }

    public void insertBack(int x){
        backSentinel.tail.tail = new intList(x,null);
        backSentinel.tail = backSentinel.tail.tail;
        size += 1;
    }

    public void printList(){
        intList temp = front;
        System.out.print(front.head+", ");
        while (temp.tail != null){
            temp = temp.tail;
            System.out.print(temp.head+", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        sList s = new sList();
        s.insertFront(2);
        s.insertFront(1);
        s.insertFront(0);
        s.insertBack(100);
        s.printList();
    }
}
