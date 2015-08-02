public class Piece{
  public boolean isFire;
  public Board b;
  public int x;
  public int y;
  public String type; // "pawn", "bomb", and "shield"

  public boolean isKing = false;
  public boolean hasCaptured = false;

  public Piece(boolean isFire, Board b, int x, int y, String type){
    this.isFire = isFire;
    this.b = b;
    this.x = x;
    this.y = y;
    this.type = type;
  }

  public boolean isFire(){
    return isFire;
  }

  public String side(){
    if (isFire){
      return "fire";
    }
    return "water";
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
    if (Board.hasCaptured!=null){
      Board.remove(Board.hasCaptured.x , Board.hasCaptured.y);
    }
    Board.pieces[x][y] = Board.remove(this.x,this.y);
    this.x = x;
    this.y = y;
    Board.moved = true;
  }

  public boolean hasCaptured(){
    return hasCaptured;
  }

  public void doneCapturing(){
    hasCaptured = false;
  }

}
