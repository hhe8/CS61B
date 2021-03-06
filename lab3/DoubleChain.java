
public class DoubleChain {

	public DNode head;
	private DNode sentinel;
	private int size;

	public DoubleChain(double val) {
		/* your code here. */

		// head is never null here so is backSentinel.next
		DNode initial = new DNode(null,val,null);
		sentinel = new DNode(initial, 123 ,initial);
		initial.next = sentinel;
		initial.prev = sentinel;
		head = sentinel;
		size = 1;
	}

	public DoubleChain() {
		/* your code here. */

		// head is never null here so is backSentinel.next
		sentinel = new DNode(null, 123 , null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		head = sentinel;
		size = 0;
	}

	public DNode getFront() {
		if (size > 0){
			return head.next;
		}
		return null;
	}

	/** Returns the last item in the DoubleChain. */
	public DNode getBack() {
		/* your code here */
		if (size > 0){
			return head.prev;
		}
		return null;
	}

	/** Adds D to the front of the DoubleChain. */
	public void insertFront(double d) {
		/* your code here */
		head.next = new DNode(head, d , head.next);
		head.next.next.prev = head.next;
		size += 1;
	}

	/** Adds D to the back of the DoubleChain. */
	public void insertBack(double d) {
		/* your code here */
		// Make sure that backSentinel.next is not null for this to work.
		//backSentinel.next is head initially;
		head.prev.next = new DNode(head.prev, d, head);
		head.prev = head.prev.next;
		size += 1;
	}

	/** Removes the last item in the DoubleChain and returns it.
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		/* your code here */
		if (size > 0){
			DNode result = head.prev;
			head.prev = head.prev.prev;
			head.prev.next = head;
			size -= 1;
			return result;
		}
		return null;
	}

	/** Returns a string representation of the DoubleChain.
	  * This is an extra challenge problem. */
	public String toString() {
		/* your code here */
		int i = size;
		if (i == 0){
			return "";
		}
		DNode ptr = head.next;
		String result = "<["+Double.toString(ptr.val);
		i -= 1;
		while (i > 0){
			ptr = ptr.next;
			result += ", "+Double.toString(ptr.val);
			i = i - 1;
		}
		result += "]>";
		return result;
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
			DoubleChain sample = new DoubleChain();
      sample.insertFront(2);
      sample.insertBack(3);
			sample.deleteBack();
			sample.deleteBack();
			sample.deleteBack();
			System.out.println(sample.toString());

			// DoubleChain sample2 = new DoubleChain(1);
			// System.out.println(sample2.head.next.next.val);
	}

}
