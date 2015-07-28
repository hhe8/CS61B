import org.junit.Test;
import static org.junit.Assert.*;

public class TestPiece{

  @Test
  public void isFireTest(){
    Board b = null;
    Piece x = new Piece(true,b,0,0,"pawn");
    assertTrue(x.isFire());
  }

  @Test
  public void isBomb(){
    Piece x = new Piece(true,null,0,0,"bomb");
    assertTrue(x.isBomb());
  }


  public static void main(String[] args) {
    jh61b.junit.textui.runClasses(TestPiece.class);
  }
}
