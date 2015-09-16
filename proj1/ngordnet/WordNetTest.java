import org.junit.Test;
import static org.junit.Assert.*;

public class WordNetTest {


    @Test
    public void testConstructor() {
      WordNet demo = new WordNet("../wordnet/synsets11.txt", "../wordnet/hyponyms11.txt");
    }

    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(WordNetTest.class);
    }

}
