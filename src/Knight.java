
public class Knight extends Piece{
  public Knight(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(Board board,int endX, int endY) {
    int startX = getPiecePositionX();
    int startY = getPiecePositionY();

    int xDiff = Math.abs(endX - startX); 
    int yDiff = Math.abs(endY - startY);

    if ((xDiff == 2 && yDiff ==1)) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    } else if (xDiff == 1 && yDiff == 2) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    }
  }

}
