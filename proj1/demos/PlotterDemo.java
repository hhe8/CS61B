import java.util.*;
import com.xeiam.xchart.*;
public class PlotterDemo{
  public static void main(String[] args) {
    NGramMap ngm = new NGramMap("../ngrams/all_words.csv",
                                "../ngrams/total_counts.csv");
    WordNet wn = new WordNet("../wordnet/synsets.txt", "../wordnet/hyponyms.txt");
    // String title = "test";
    // String xlabel = "x";
    // String ylabel = "y";
    // String legend = "test";
    // TimeSeries<Double> ts = ngm.weightHistory("quantity");
    // Plotter.plotTS(ts,title,xlabel,ylabel,legend);
    // Plotter.plotCountHistory(ngm,"computer",1990,2005);
    // Plotter.plotWeightHistory(ngm,"computer",1900,2005);
    String[] categoryLabels = {"computer","bank","statistics","data"};
    Plotter.plotCategoryWeights(ngm,wn,categoryLabels,1900,2010);
  }
}
