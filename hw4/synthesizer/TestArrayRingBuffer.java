package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void enqueueTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        arb.enqueue(2);
        assertEquals(1,arb.dequeue(),0.001);
        assertEquals(2,arb.peek(),0.001);
        assertEquals(2,arb.dequeue(),0.001);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
