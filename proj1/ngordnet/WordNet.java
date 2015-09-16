import edu.princeton.cs.introcs.In;
import edu.princeton.cs.algs4.Digraph;
import java.util.*;

public class WordNet {
    /** Creates a WordNet using files form SYNSETFILENAME and HYPONYMFILENAME */


    public WordNet(String synsetFilename, String hyponymFilename){
      In synsetStream = new In(synsetFilename);
      In hyponymStream = new In(hyponymFilename);
      while (synsetStream.hasNextLine()){
        String line = synsetStream.readLine();
        String[] tokens = line.split(",");
        System.out.print(tokens[0]);
        System.out.print(tokens[1] + "\n");
      }

      while (hyponymStream.hasNextLine()){
        System.out.println(hyponymStream.readLine());
      }

    }

    /* Returns true if NOUN is a word in some synset. */
    public boolean isNoun(String noun){
      return false;
    }

    /* Returns the set of all nouns. */
    public Set<String> nouns(){
      return null;
    }

    /** Returns the set of all hyponyms of WORD as well as all synonyms of
      * WORD. If WORD belongs to multiple synsets, return all hyponyms of
      * all of these synsets. See http://goo.gl/EGLoys for an example.
      * Do not include hyponyms of synonyms.
      */
    public Set<String> hyponyms(String word){
      return null;
    }
}
