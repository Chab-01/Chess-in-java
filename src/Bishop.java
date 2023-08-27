
public class Bishop extends Piece{
  public Bishop(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(Board board,int endX, int endY) {
    int startX = getPiecePositionX();
    int startY = getPiecePositionY();

    int xDiff = Math.abs(endX - startX); 
    int yDiff = Math.abs(endY - startY);

    if (xDiff == yDiff) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    }
  }
}
