package ngordnet;
import java.util.*;
public class YearlyRecord {

    // primary map to store the word -> count;
    Map<String,Integer> countMap;
    boolean cached;
    Map<String,Integer> rankMap;
    Map<String,Integer> sortedMap;

    Set<String> sortedWords;
    Set<Number> sortedCounts;

    /** Creates a new empty YearlyRecord. */
    public YearlyRecord(){
      countMap = new HashMap<String, Integer>();
      sortedMap = new HashMap<String,Integer>();
      rankMap = new HashMap<String,Integer>();
      cached = false;
      sortedWords = new TreeSet<String>();
      sortedCounts = new TreeSet<Number>();
    }

    /** Creates a YearlyRecord using the given data. */
    public YearlyRecord(HashMap<String, Integer> otherCountMap){
        this();
        countMap = new HashMap<String,Integer>(otherCountMap);
    }

    /** Returns the number of times WORD appeared in this year. */
    public int count(String word){
      return countMap.get(word);
    }

    /** Records that WORD occurred COUNT times in this year. */
    public void put(String word, int count){
      countMap.put(word,count);
      cached = false;
    }

    /** Returns the number of words recorded this year. */
    public int size(){
      return countMap.size();
    }

    /** Returns all words in ascending order of count. */
    public Collection<String> words(){
      if (cached == false){
        this.rankBuild();
      }
      return sortedWords;
    }

    /** Returns all counts in ascending order of count. */
    public Collection<Number> counts(){
      if (cached == false){
        this.rankBuild();
      }
      return sortedCounts;
    }

    /** Returns rank of WORD. Most common word is rank 1.
      * If two words have the same rank, break ties arbitrarily.
      * No two words should have the same rank.
      */
    private void rankBuild(){
      // sort the countMap by the value (count)
      sortedMap = SortMap.sortByValue(countMap);

      // Build ranked map
      rankMap = new HashMap<String,Integer>();
      int size = sortedMap.size();
      for (String word : sortedMap.keySet()){
        rankMap.put(word,size);
        size -= 1;
      }

      // build the sortedWords and sortedCounts Set.
      sortedWords = rankMap.keySet();
      for (String word : sortedWords){
        sortedCounts.add(sortedMap.get(word));
      }
      cached = true;
    }

    public int rank(String word){
      if (cached == false){
        this.rankBuild();
      }
      cached = true;
      return rankMap.get(word);
    }
}
