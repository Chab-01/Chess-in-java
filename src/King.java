public class King extends Piece {
  public King(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(Board board, int endX, int endY) {
    int startX = getPiecePositionX();
    int startY = getPiecePositionY();
    int xDiff = Math.abs(endX - startX); // Diff variables used to make sure the king can't move more than 1 square away from its original starting point
    int yDiff = Math.abs(endY - startY);

    if ((xDiff <= 1 && yDiff <= 1)) {
      setPiecePosition(endX, endY);
      board.killPiece(Game.targetedPiece);
    } 
  }
}
