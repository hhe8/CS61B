package ngordnet;
import java.util.*;
import com.xeiam.xchart.*;
public class Plotter {
    /** Creates a plot of the TimeSeries TS. Labels the graph with the
      * given TITLE, XLABEL, YLABEL, and LEGEND. */
    public static void plotTS(TimeSeries<? extends Number> ts, String title,
                              String xlabel, String ylabel, String legend){
                                Chart chart = QuickChart.getChart(title,xlabel,ylabel,legend,ts.years(),ts.data());
                                new SwingWrapper(chart).displayChart();
                              }

    /** Creates a plot of the absolute word counts for WORD from STARTYEAR
      * to ENDYEAR, using NGM as a data source. */
    public static void plotCountHistory(NGramMap ngm, String word, int startYear, int endYear){
      TimeSeries<Integer> ts = ngm.countHistory(word,startYear,endYear);
      plotTS(ts,word+" Count History","X","Y",word);
    }

    /** Creates a plot of the normalized weight counts for WORD from STARTYEAR
      * to ENDYEAR, using NGM as a data source. */
    public static void plotWeightHistory(NGramMap ngm, String word, int startYear, int endYear){
      plotTS(ngm.weightHistory(word,startYear,endYear),word+ " Weighted History","X","Y",word);
    }

    // /** Creates a plot of the processed history from STARTYEAR to ENDYEAR, using
    //   * NGM as a data source, and the YRP as a yearly record processor. */
    // public static void plotProcessedHistory(NGramMap ngm, int startYear, int endYear, YearlyRecordProcessor yrp){
    //
    // }

    /** Creates a plot of the total normalized count of WN.hyponyms(CATEGORYLABEL)
      * from STARTYEAR to ENDYEAR using NGM and WN as data sources. */
    public static void plotCategoryWeights(NGramMap ngm, WordNet wn, String categoryLabel,
                                            int startYear, int endYear)
    {
      plotTS(ngm.summedWeightHistory(wn.hyponyms(categoryLabel),startYear,endYear),categoryLabel+" Category Weight History","X","Y",categoryLabel);
    }



    /** Creates overlaid category weight plots for each category label in CATEGORYLABELS
      * from STARTYEAR to ENDYEAR using NGM and WN as data sources. */
    public static void plotCategoryWeights(NGramMap ngm, WordNet wn, String[] categoryLabels,
                                            int startYear, int endYear)
    {
      Chart chart = new Chart(500, 400);
      chart.setChartTitle("Overlaid Category Weight");
      chart.setXAxisTitle("X");
      chart.setYAxisTitle("Y");
      for (String category : categoryLabels){
        TimeSeries<Double> ts = ngm.summedWeightHistory(wn.hyponyms(category),startYear,endYear);
        chart.addSeries(category, ts.years(), ts.data());
      }
      new SwingWrapper(chart).displayChart();
    }
    /** Makes a plot showing overlaid individual normalized count for every word in WORDS
      * from STARTYEAR to ENDYEAR using NGM as a data source. */
    public static void plotAllWords(NGramMap ngm, String[] words, int startYear, int endYear){
      Chart chart = new Chart(500, 400);
      chart.setChartTitle("Overlaid Individual Weight");
      chart.setXAxisTitle("X");
      chart.setYAxisTitle("Y");
      for (String word : words){
        TimeSeries<Double> ts = ngm.weightHistory(word,startYear,endYear);
        chart.addSeries(word, ts.years(), ts.data());
      }
      new SwingWrapper(chart).displayChart();
    }
    //
    // /** Returns the numbers from max to 1, inclusive in decreasing order.
    //   * Private, so you don't have to implement if you don't want to. */
    // private static Collection<Number> downRange(int max)
    //
    // /** Plots the count (or weight) of every word against the rank of every word on a
    //   * log-log plot. Uses data from YEAR, using NGM as a data source. */
    // public static void plotZipfsLaw(NGramMap ngm, int year)
}
