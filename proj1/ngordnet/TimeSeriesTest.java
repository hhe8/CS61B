import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TimeSeriesTest {


    @Test
    public void testMain() {
      TimeSeries<Double> ts = new TimeSeries<Double>();
      ts.put(1992,1.1);
      ts.put(1993,0.2);
      ts.put(1994,20.1);
      ts.put(1995,11.2);
      ts.put(1996,19.1);

      TimeSeries<Integer> ts2 = new TimeSeries<Integer>();
      ts2.put(1992,1);
      ts2.put(1993,10);
      ts2.put(1994,20);
      ts2.put(1995,11);
      ts2.put(1996,19);
      ts2.put(1997,100);

      TimeSeries<Double> ts5 = new TimeSeries<Double>(ts,1993,1995);


      TimeSeries<Double> ts3 = ts.dividedBy(ts2);
      TimeSeries<Double> ts4 = ts.plus(ts2);

      assertEquals(1.1, ts3.get(1992) , 0.05);
      assertEquals(100,ts4.get(1997),0.01);
      assertEquals(2.1,ts4.get(1992),0.01);
      assertEquals(0.0, ts3.get(1997), 0.01);

      Collection<Number> years = ts5.years();
      Collection<Number> data = ts5.data();
      System.out.println(years);
      System.out.println(data);
    //   for (Number yearNumber : years) {
    //       /* This awkward conversion is necessary since you cannot
    //        * do yearNumber.get(yearNumber), since get expects as
    //        * Integer since TimeSeries always require an integer
    //        * key.
    //        *
    //        * Your output may be in any order. */
    //       int year = yearNumber.intValue();
    //       double value = ts.get(year);
    //       System.out.println("In the year " + year + " the value was " + value);
    //   }
    //   for (Number dataNumber : data) {
    //        /* Your dataNumber values must print out in the same order as the
    //         * they did in the previous for loop. */
    //       double datum = dataNumber.doubleValue();
    //       System.out.println("In some year, the value was " + datum);
    //   }
    }


    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TimeSeriesTest.class);
    }

}
