package ngordnet;
public class WordLengthProcessor implements YearlyRecordProcessor {
    public double process(YearlyRecord yearlyRecord){
      int totalWordLength = 0;
      long totalCount = 0;
      for (String word : yearlyRecord.words()){
        totalWordLength += word.length()*yearlyRecord.count(word);
        totalCount += yearlyRecord.count(word);
      }
      return totalWordLength/(double) totalCount;
    }
}
