public class Piece{
  public boolean isFIre;
  public Board b;
  public int x;
  public int y;
  public String type; // "pawn", "bomb", and "shield"

  public boolean isKing = False;
  public boolean hasCaptured = False;

  public Piece(boolean isFire, Board b, int x, int y, String type){
    this.isFire = isFire;
    this.b = b;
    this.x = x;
    this.y = y;
    this.type = type;
  }

  public void isFire(){
    return isFire;
  }

  public int side(){
    if (isFire){
      return 0;
    }
    return 1;
  }

  public boolean isKing(){
    return isKing;
  }

  // public void crown(){
  //   isKing = Ture
  // }

  public boolean isBomb(){
    return (type == "bomb");
  }

  public boolean isShield(){
    return (type == "shield");
  }

  public void move(int x, int y){

  }

  public boolean hasCaptured(){
    return hasCaptured;
  }

  public void doneCapturing(){
    hasCaptured = False;
  }

}
