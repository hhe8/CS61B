package ngordnet;

import java.util.*;
import java.lang.Math.*;

public class TimeSeries<T extends Number> extends TreeMap<Integer, T> {
    /** Constructs a new empty TimeSeries. */
    public TimeSeries(){
      super();
    }

    /** Creates a copy of TS, but only between STARTYEAR and ENDYEAR.
     * inclusive of both end points. */
    public TimeSeries(TimeSeries<T> ts, int startYear, int endYear){
      super(ts.subMap(startYear,true,endYear,true));
    }

    /** Creates a copy of TS. */
    public TimeSeries(TimeSeries<T> ts){
      super(ts);
    }

    /** Returns the quotient of this time series divided by the relevant value in ts.
      * If ts is missing a key in this time series, return an IllegalArgumentException. */
    public TimeSeries<Double> dividedBy(TimeSeries<? extends Number> ts){
      for (Integer year : this.keySet()){
        if (ts.get(year) == null){
          System.out.println(year);
          throw new IllegalArgumentException();
        }
      }

      TimeSeries<Double> result = new TimeSeries<Double>();
      for (Integer year : ts.keySet()){
        if (this.get(year) == null){
          result.put(year,0.0);
        } else {
          result.put(year,this.get(year).doubleValue()/ts.get(year).doubleValue());
        }
      }
      return result;
    }

    /** Returns the sum of this time series with the given ts. The result is a
      * a Double time series (for simplicity). */
    public TimeSeries<Double> plus(TimeSeries<? extends Number> ts){
      Number a;
      Number b;
      TimeSeries<Double> result = new TimeSeries<Double>();
      int yearMin = Math.min(ts.firstKey(),this.firstKey());
      int yearMax = Math.max(ts.lastKey(),this.lastKey());
      for (int year = yearMin; year <= yearMax; year++){
        a = ts.get(year);
        b = this.get(year);
        if (b == null){
          b = 0.0;
        }
        if (a == null){
          a = 0.0;
        }
        result.put(year,a.doubleValue()+b.doubleValue());
      }
      return result;
    }

    /** Returns all years for this time series (in any order). */
    public Collection<Number> years(){
      Collection<Number> result = new TreeSet<Number>();
      // for (Integer year : this.keySet()){
      //   result.add(year);
      // }
      result.addAll(this.keySet());
      return result;
    }

    /** Returns all data for this time series.
      * Must be in the same order as years(). */
    public Collection<Number> data(){
      Collection<Number> result = new ArrayList<Number>();
      for (Integer year : this.keySet()){
        result.add(this.get(year));
      }
      return result;
    }
}
