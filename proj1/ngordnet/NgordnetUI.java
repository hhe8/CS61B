/* Starter code for NgordnetUI (part 7 of the project). Rename this file and
   remove this comment. */

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.In;

/** Provides a simple user interface for exploring WordNet and NGram data.
 *  @author [Huimin He]
 */
public class NgordnetUI {
    public static void main(String[] args) {
        In in = new In("../ngordnet/ngordnetui.config");
        System.out.println("Reading ngordnetui.config...");

        String wordFile = in.readString();
        String countFile = in.readString();
        String synsetFile = in.readString();
        String hyponymFile = in.readString();
        System.out.println("\nBased on ngordnetui.config, using the following: "
                           + wordFile + ", " + countFile + ", " + synsetFile +
                           ", and " + hyponymFile + ".");
        WordNet wn = new WordNet(synsetFile,hyponymFile);
        NGramMap ngm = new NGramMap(wordFile,countFile);

        while (true) {
            int startDate = ngm.totalCountHistory().firstKey();
            int endDate = ngm.totalCountHistory().lastKey();

            System.out.print("> ");
            String line = StdIn.readLine();
            String[] rawTokens = line.split(" ");
            String command = rawTokens[0];
            String[] tokens = new String[rawTokens.length - 1];
            System.arraycopy(rawTokens, 1, tokens, 0, rawTokens.length - 1);

            switch (command) {
                case "quit":
                    return;
                case "help":
                    In help = new In("help.txt");
                    String helpStr = help.readAll();
                    System.out.println(helpStr);
                    break;
                case "range":
                    startDate = Integer.parseInt(tokens[0]);
                    endDate = Integer.parseInt(tokens[1]);
                    System.out.println("Start date: " + startDate);
                    System.out.println("End date: " + endDate);
                    break;
                case "count":
                    System.out.println(ngm.countHistory(tokens[0]).get(Integer.parseInt(tokens[1])));
                    break;
                case "hyponyms":
                    System.out.println(wn.hyponyms(tokens[0]));
                    break;
                case "history":
                    Plotter.plotAllWords(ngm,tokens,startDate,endDate);
                    break;
                case "hypohist":
                    Plotter.plotCategoryWeights(ngm,wn,tokens,startDate,endDate);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

    }
}
