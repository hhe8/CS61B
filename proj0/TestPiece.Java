import org.junit.Test;
import static org.junit.Assert.*;

public class TestPiece{

  @Test
  public void isFireTest(){
    Board b = new Board();
    Piece x = new Piece(True,b,0,0,"pawn");
    assertTrue(True,x.isFire());
  }

  @Test


  public static void main(String[] args) {
    jh61b.junit.textui.runClasses(TestPiece.class);
  }
}
