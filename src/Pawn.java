public class Pawn extends Piece {
  private boolean firstMove = false;

  public Pawn(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(Board board, int endX, int endY) {
    int startX = getPiecePositionX();
    int startY = getPiecePositionY();

    int xDiff = Math.abs(endX - startX);
    int yDiff = Math.abs(endY - startY);

    int yDirection = isWhite() ? 1 : -1; // prevent from going backwards, 1 and -1 depending on color

    if (!firstMove) {
      if (xDiff == 0 && yDiff >= 1 && yDiff <= 2 && endY == startY + yDirection * 2) { // Move two squares for first move
        setPiecePosition(endX, endY);
        firstMove = true;
      } else if (xDiff == 0 && yDiff >= 1 && yDiff <= 1 && endY == startY + yDirection) { // Move one square for first move
        setPiecePosition(endX, endY);
        firstMove = true;
      }
    } else {
      if (xDiff == 0 && yDiff == 1 && endY == startY + yDirection) { // Move one square after first move
        setPiecePosition(endX, endY);
      } else if (xDiff == 1 && yDiff == 1 && board.getPiece(endX, endY) != null && board.getPiece(endX, endY).isWhite() != isWhite()) { // Kill diagonally if color is not the same
        setPiecePosition(endX, endY);
        board.killPiece(Game.targetedPiece);
      }
    }
  }
}
