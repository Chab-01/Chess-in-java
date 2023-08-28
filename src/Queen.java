
public class Queen extends Piece{
  public Queen(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(Board board,int endX, int endY) {
    int startX = getPiecePositionX();
    int startY = getPiecePositionY();

    int xDiff = Math.abs(endX - startX); 
    int yDiff = Math.abs(endY - startY);

    if (xDiff <=7 && xDiff >=0 && yDiff == 0) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    } else if (xDiff == 0 && yDiff <=7 && yDiff >= 0) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    }
    else if (xDiff == yDiff) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    }
  }
}
