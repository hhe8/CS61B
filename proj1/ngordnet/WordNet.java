import edu.princeton.cs.introcs.In;
import edu.princeton.cs.algs4.Digraph;
import java.util.*;

public class WordNet {
    /** Creates a WordNet using files form SYNSETFILENAME and HYPONYMFILENAME */


    public WordNet(String synsetFilename, String hyponymFilename){
      In synsetStream = new In(synsetFilename);
      In hyponymStream = new In(hyponymFilename);
      System.out.println(synsetStream.readInt());
      // while (synsetStream.hasNextLine()){
      //   System.out.println(synsetStream.readInt());
      //   System.out.println(synsetStream.readString());
      //   synsetStream.readString();
      // }

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
