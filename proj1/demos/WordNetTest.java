import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class WordNetTest {


    @Test
    public void testConstructor() {
      WordNet demo = new WordNet("../wordnet/synsets.txt", "../wordnet/hyponyms.txt");
      // for (Map.Entry<String,HashSet<Integer>> entry : demo.wordMap.entrySet()){
      //   System.out.println(entry.getKey() + ":" + entry.getValue());
      // }
      // System.out.println(demo.nVertices);

      // for (Map.Entry<Integer,HashSet<String>> entry : demo.idMap.entrySet()){
      //   System.out.println(entry.getKey() + ":" + entry.getValue());
      // }

      // System.out.println(demo.wordGraph);
      // HashSet<Integer> zero = new HashSet<Integer>();
      // zero.add(0);
      // System.out.println(GraphHelper.descendants(demo.wordGraph, zero));
      System.out.println("\nHyponyms of fuck:");
      System.out.println(demo.hyponyms("fuck"));
    }


    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(WordNetTest.class);
    }

}
