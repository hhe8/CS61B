import static org.junit.Assert.*;
import org.junit.Test;

public class generalTest{


    @Test
    public void selectorTest(){
        intList s = new intList(10, new intList(1,null));
        assertEquals(s.head,10);
    }

    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(generalTest.class);
    }


}
