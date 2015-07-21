
public class DoubleChain {

	private DNode head;
	private DNode backSentinel;

	public DoubleChain(double val) {
		/* your code here. */

		// head is never null here so is backSentinel.next
		head = new DNode(null,val,null);
		backSentinel = new DNode(null, 0 ,head);
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */
	public DNode getBack() {
		/* your code here */
		return backSentinel.next;
	}

	/** Adds D to the front of the DoubleChain. */
	public void insertFront(double d) {
		/* your code here */
		head = new DNode(null, d , head);
	}

	/** Adds D to the back of the DoubleChain. */
	public void insertBack(double d) {
		/* your code here */
		// Make sure that backSentinel.next is not null for this to work.
		//backSentinel.next is head initially;
		backSentinel.next.next = new DNode(backSentinel.next, d , null);
		backSentinel.next = backSentinel.next.next;
	}

	/** Removes the last item in the DoubleChain and returns it.
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		if (backSentinel.next.prev == null) {
				System.out.println("cant delete the last item in the list");
				return null;
		}
		/* your code here */
		DNode temp = backSentinel.next;
		//make sure backSentinel.next.prev is not null;
		backSentinel.next = backSentinel.next.prev;
		backSentinel.next.next = null;
		return temp;
	}

	/** Returns a string representation of the DoubleChain.
	  * This is an extra challenge problem. */
	public String toString() {
		/* your code here */
		DNode ptr = head;
		String result = "<["+Double.toString(ptr.val);
		while (ptr.next!=null){
			ptr = ptr.next;
			result += ", "+Double.toString(ptr.val);
		}
		result += "]>";
		return result;
	}

	public void delete(int i){
		
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;

		private DNode(double val) {
			this(null, val, null);
		}

		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next =next;
		}
	}

	public static void main(String[] args) {
			DoubleChain sample = new DoubleChain(1);
      sample.insertBack(2);
      sample.insertBack(3);
			System.out.println(sample.toString());
	}

}
