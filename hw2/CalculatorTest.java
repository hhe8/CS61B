import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your
     * tests.  To use your unit tests for your own implementation, comment
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        //tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE
    @Test
    public void addTest(){
        int result = tester.add(10,25);
        //System.out.println(result);
        assertEquals(35,result);
        assertEquals(100,tester.add(50,50));
        assertEquals(-100,tester.add(100,-200));
        assertEquals(99,tester.add(-1,100));
        assertEquals(0,tester.add(-100,100));
    }

    @Test
    public void mulTest(){
        assertEquals(40,tester.multiply(20,2));
        assertEquals(60,tester.multiply(20,3));
        int result = tester.multiply(-20,-10);
        System.out.println(result);
        assertEquals(200,result);
    }
    

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }
}
