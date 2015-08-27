import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("GraciasL", "Dios BasadoD");
        assertEquals(um.get("Gracias"), "Dios Basado");
        assertEquals(um.get("GraciasL"), "Dios BasadoD");
    }


    @Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
        System.out.println(umi.next());
        System.out.println(umi.next());
    }

    @Test
    public void testInvert() {
        ULLMap<String, Integer> um = new ULLMap<String, Integer>();
        um.put("Gracias", 1 );
        um.put("GraciasL", 2);
        ULLMap<Integer,String> umi = ULLMap.invert(um);
        assertEquals(umi.get(1),"Gracias");
        assertEquals(umi.get(2),"GraciasL");
    }

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
}
