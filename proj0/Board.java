public class Board{

  public static int N = 8;
  public static Piece[][] pieces;
  public static int player = 0;

  public static Piece selectedPiece;
  public static boolean moved;
  public static boolean hasCaptured;

  public Board(boolean shouldBeEmpty){
    if (shouldBeEmpty){
    }
    selectedPiece = null;
    moved = false;
    hasCaptured = false;

    StdDrawPlus.setXscale(0, N);
    StdDrawPlus.setYscale(0, N);
    pieces = new Piece[N][N];
    for (int j = 0; j < N; j++){
      if (j%2 == 0) pieces[j][0] = new Piece(true,this,j,0,"pawn");
    }
    for (int j = 0; j < N; j++){
      if (j%2 == 1) pieces[j][1] = new Piece(true,this,j,1,"shield");
    }
    for (int j = 0; j < N; j++){
      if (j%2 == 0) pieces[j][2] = new Piece(true,this,j,2,"bomb");
    }


    for (int j = 0; j < N; j++){
      if (j%2 == 1) pieces[j][7] = new Piece(false,this,j,7,"pawn");
    }
    for (int j = 0; j < N; j++){
      if (j%2 == 0) pieces[j][6] = new Piece(false,this,j,6,"shield");
    }
    for (int j = 0; j < N; j++){
      if (j%2 == 1) pieces[j][5] = new Piece(false,this,j,5,"bomb");
    }
  }

  public static Piece pieceAt(int x, int y){
    if (outOfBound(x,y)){
      return null;
    }
    return pieces[x][y];
  }

  private static boolean outOfBound(int x, int y){
    if (x > 7 || x < 0 || y > 7 || y < 0){
      return true;
    }
    return false;
  }

  public static void switchTurn(){
    //player side fire or water
    if (player == 0){
      player = 1;
    }
    else {
      player = 1;
    }
  }


  public static boolean canSelect(int x, int y){
    if (pieces[x][y]!=null && (selectedPiece == null || (selectedPiece != null && moved == false))){
      return true;
    }

    if ((pieces[x][y] == null)  && (selectedPiece != null && moved == false) && validMove(selectedPiece,x,y)){
      return true;
    }

    if ((pieces[x][y] == null) && (selectedPiece != null && (selectedPiece.hasCaptured() && validMove(selectedPiece,x,y) ))){
      return true;
    }

    return false;
  }

  public static boolean validMove(Piece selectedPiece, int x, int y){
    if (pieceAt(x,y)==null && !outOfBound(x,y)) {
      if ((Math.abs(selectedPiece.x - x) < 1 && Math.abs(selectedPiece.y - y) < 1) ){
        return true;
      }
      if (((Math.abs(selectedPiece.x - x) == 2) && (Math.abs(selectedPiece.y -y) == 2)) && pieceAt(selectedPiece.x + (x - selectedPiece.x)/2, selectedPiece.y + (y - selectedPiece.y)/2)!=null ){
        if (selectedPiece.isFire() != pieces[x][y].isFire()) {return true;}
      }
    }

    if (pieceAt(x,y)!=null){
      return false;
    }
    return false;
  }

  public static void select(int x , int y){
    if (pieceAt(x,y)!=null){
      System.out.println("selecting new");
      selectedPiece = pieces[x][y];
    }
    if (selectedPiece != null && pieceAt(x,y)==null){
      System.out.println("moving piece");
      selectedPiece.move(x,y);
    }
  }
  //
  public void place(Piece p, int x, int y){
    if (outOfBound(x,y) || p == null){
    } else {
      pieces[x][y] = p;
    }
  }
  //
  public static Piece remove(int x, int y){
    if (outOfBound(x,y)){
      System.out.println("out of bound");
      return null;
    } else {
      Piece ans = pieces[x][y];
      pieces[x][y] = null;
      return ans;
    }
  }
  //
  public static boolean canEndTurn(){
    if (moved == true || hasCaptured == true){
      return true;
    }
    return false;
  }
  //
  public static void endTurn(){
    selectedPiece = null;
    moved = false;
    hasCaptured = false;
    switchTurn();
  }
  //
  // public String winnner(){
  //
  // }


  /** Draws an N x N board. Adapted from:
      http://introcs.cs.princeton.edu/java/15inout/CheckerBoard.java.html
   */

  private static void drawBoard(int N) {
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
              else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
              StdDrawPlus.filledSquare(i + .5, j + .5, .5);
              StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
              if (pieces[i][j] != null) {
                  StdDrawPlus.picture(i + .5, j + .5, "img/"+pieces[i][j].type +"-"+ pieces[i][j].side() +".png", 1, 1);
              }
          }
      }
  }

  // public static void main(String[] args) {
  //     int N = 8;
  //     StdDrawPlus.setXscale(0, N);
  //     StdDrawPlus.setYscale(0, N);
  //     pieces = new boolean[N][N];
  //
  //     /** Monitors for mouse presses. Wherever the mouse is pressed,
  //         a new piece appears. */
  //     while(true) {
  //         drawBoard(N);
  //         if (StdDrawPlus.mousePressed()) {
  //             double x = StdDrawPlus.mouseX();
  //             double y = StdDrawPlus.mouseY();
  //             pieces[(int) x][(int) y] = true;
  //         }
  //         StdDrawPlus.show(100);
  //     }
  // }

  public static void main(String[] args) {
    Board b = new Board(false);

    while(true) {
      drawBoard(N);
      while(!canEndTurn()){
        if (StdDrawPlus.mousePressed()) {
            System.out.println(" ");
            System.out.println("pressed");
            double x = StdDrawPlus.mouseX();
            double y = StdDrawPlus.mouseY();
            System.out.println((int) x+","+ (int) y);

            if (true || canSelect((int) x,(int) y)){
              select((int) x, (int) y);
              //System.out.println("selected" + selectedPiece.x + ',' + selectedPiece.y);

            }
        }
        StdDrawPlus.show(100);
      }
      endTurn();
      System.out.println("ending turn");
      StdDrawPlus.show(100);
    }
  }

}
