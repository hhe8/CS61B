import org.junit.Test;
import static org.junit.Assert.*;

public class TestBoard{

  @Test
  public void TestswitchTurn(){
    //Board b= new Board(true);
    Board.player = 0;
    assertEquals(0,Board.player);
    Board.switchTurn();
    assertEquals(1,Board.player);
  }



  public static void main(String[] args) {
    jh61b.junit.textui.runClasses(TestBoard.class);
  }
}
