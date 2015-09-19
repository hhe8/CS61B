import java.util.*;

public class NGramMap {
    /** Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME. */
    public Map<String,TimeSeries<Integer>> wordTimeSeries;
    public TimeSeries<Long> yearTotalCount;
    public Map<Integer,YearlyRecord> yearRecord;

    public NGramMap(String wordsFilename, String countsFilename){

      // Input stream;
      wordTimeSeries = new HashMap<String,TimeSeries<Integer>>();
      yearTotalCount = new TimeSeries<Long>();
      yearRecord = new HashMap<Integer,YearlyRecord>();

      In wordStream = new In(wordsFilename);
      In countStream = new In(countsFilename);
      while (wordStream.hasNextLine()){
      // read wordStream and build the wordTimeSeries;
        String tokens[] = wordStream.readLine().split("\t");
        String word = tokens[0];
        Integer year = Integer.parseInt(tokens[1]);
        Integer count = Integer.parseInt(tokens[2]);
        if (wordTimeSeries.get(word) == null){
          TimeSeries<Integer> value = new TimeSeries<Integer>();
          value.put(year,count);
          wordTimeSeries.put(word,value);
        } else {
          TimeSeries<Integer> value = wordTimeSeries.get(word);
          value.put(year,count);
          wordTimeSeries.put(word,value);
        }

        // build the yearRecord map from year -> YearlyRecord;
        if (yearRecord.get(year) == null){
          YearlyRecord newYear = new YearlyRecord();
          newYear.put(word,count);
          yearRecord.put(year,newYear);
        } else {
          YearlyRecord oldYear = yearRecord.get(year);
          oldYear.put(word,count);
          yearRecord.put(year,oldYear);
        }
      }

      // read countStream and build the yearTotalCount;
      while(countStream.hasNextLine()){
        String tokens[] = countStream.readLine().split(",");
        Integer year = Integer.parseInt(tokens[0]);
        Long count = Long.parseLong(tokens[1],10);
        yearTotalCount.put(year,count);
      }
    }

    /** Returns the absolute count of WORD in the given YEAR. If the word
      * did not appear in the given year, return 0. */
    public int countInYear(String word, int year){
      if (wordTimeSeries.get(word) == null){
        return 0;
      } else if (wordTimeSeries.get(word).get(year) == null){
        return 0;
      } else {
        return wordTimeSeries.get(word).get(year);
      }
    }
    //
    /** Returns a defensive copy of the YearlyRecord of YEAR. */
    public YearlyRecord getRecord(int year){
    //!!!!! how to make this defensive? --------------------!!!!!!!!!!!!!!!!!!!//
      return yearRecord.get(year);
    }

    /** Returns the total number of words recorded in all volumes. */
    public TimeSeries<Long> totalCountHistory(){
      return yearTotalCount;
    }

    /** Provides the history of WORD between STARTYEAR and ENDYEAR. */
    public TimeSeries<Integer> countHistory(String word, int startYear, int endYear){
      return new TimeSeries<Integer>(wordTimeSeries.get(word),startYear,endYear);
    }
    //
    // /** Provides a defensive copy of the history of WORD. */
    public TimeSeries<Integer> countHistory(String word){
      return new TimeSeries<Integer>(wordTimeSeries.get(word));
    }
    //
    /** Provides the relative frequency of WORD between STARTYEAR and ENDYEAR. */
    public TimeSeries<Double> weightHistory(String word, int startYear, int endYear){
      return (new TimeSeries<Integer>(wordTimeSeries.get(word),startYear,endYear)).dividedBy(new TimeSeries<Long>(yearTotalCount,startYear,endYear));
    }

    /** Provides the relative frequency of WORD. */
    public TimeSeries<Double> weightHistory(String word){
      return wordTimeSeries.get(word).dividedBy(yearTotalCount);
    }

    /** Provides the summed relative frequency of all WORDS between
      * STARTYEAR and ENDYEAR. If a word does not exist, ignore it rather
      * than throwing an exception. */
    public TimeSeries<Double> summedWeightHistory(Collection<String> words,
                                                  int startYear, int endYear){
      return new TimeSeries<Double>(summedWeightHistory(words),startYear,endYear);

    }
    
    /** Returns the summed relative frequency of all WORDS. */
    public TimeSeries<Double> summedWeightHistory(Collection<String> words){
      TimeSeries<Double> result;
      Iterator<String> iter = words.iterator();
      String word = iter.next();
      while (wordTimeSeries.get(word)==null){
        word = iter.next();
      }

      result = weightHistory(word);

      while(iter.hasNext()){
        word = iter.next();
        if (wordTimeSeries.get(word) != null){
          result = result.plus(weightHistory(word));
        }
      }
      return result;
    }

    // /** Provides processed history of all words between STARTYEAR and ENDYEAR as processed
    //   * by YRP. */
    // public TimeSeries<Double> processedHistory(int startYear, int endYear,
    //                                            YearlyRecordProcessor yrp)
    //
    // /** Provides processed history of all words ever as processed by YRP. */
    // public TimeSeries<Double> processedHistory(YearlyRecordProcessor yrp)
}
