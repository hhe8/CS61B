import edu.princeton.cs.introcs.In;
import edu.princeton.cs.algs4.Digraph;
import java.util.*;
package ngordnet;

public class WordNet {
    /** Creates a WordNet using files form SYNSETFILENAME and HYPONYMFILENAME */
    private In synsetStream;
    private In hyponymStream;
    public int nVertices;

    // a map from word to a set of synset id
    public HashMap<String,HashSet<Integer>> wordMap;
    // a map from synset id to a set of words;
    public HashMap<Integer,HashSet<String>> idMap;
    // Digraph for the wordNet
    public Digraph wordGraph;

    public WordNet(String synsetFilename, String hyponymFilename){
      nVertices = 0;
      int id;
      wordMap = new HashMap<String,HashSet<Integer>>();
      idMap = new HashMap<Integer,HashSet<String>>();
      synsetStream = new In(synsetFilename);
      hyponymStream = new In(hyponymFilename);

      // read the synset file line by line and construct mapping from word to
      // set of synset id;
      while (synsetStream.hasNextLine()){
        String line = synsetStream.readLine();
        String[] tokens = line.split(",");
        String[] words = tokens[1].split(" ");
        id = Integer.parseInt(tokens[0]);

        // create the map from synset id to a set of words;
        HashSet<String> synSet = new HashSet<String>(Arrays.asList(words));
        idMap.put(id,synSet);
        // construct the wordMap - from word to synset id;
        for (String word : words){
          if (!wordMap.containsKey(word)){
            HashSet<Integer> idSet = new HashSet<Integer>();
            idSet.add(id);
            wordMap.put(word,idSet);
          } else {
            HashSet<Integer> temp = wordMap.get(word);
            temp.add(id);
            wordMap.put(word,temp);
          }
          // synSet.add(word);
        }
        // wordMap.put(,);
        nVertices += 1;
      }

    // construct the digraph;
    wordGraph = new Digraph(nVertices);
    while (hyponymStream.hasNextLine()){
      String[] tokens = hyponymStream.readLine().split(",");
      for (int i = 1; i < tokens.length; i++){
        wordGraph.addEdge(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[i]));
      }
    }

    }

    /* Returns true if NOUN is a word in some synset. */
    public boolean isNoun(String noun){
      return wordMap.containsKey(noun);
    }

    /* Returns the set of all nouns. */
    public Set<String> nouns(){
      return wordMap.keySet();
    }

    /** Returns the set of all hyponyms of WORD as well as all synonyms of
      * WORD. If WORD belongs to multiple synsets, return all hyponyms of
      * all of these synsets. See http://goo.gl/EGLoys for an example.
      * Do not include hyponyms of synonyms.
      */
    public Set<String> hyponyms(String word){
      HashSet<String> result = new HashSet<String>();
      for (int id : GraphHelper.descendants(wordGraph, wordMap.get(word))){
        result.addAll(idMap.get(id));
      }
      return result;

    }
}
