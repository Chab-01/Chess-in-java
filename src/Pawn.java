
public class Pawn extends Piece{
  public Pawn(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(int start, int end) {
    setPiecePosition(start, end);
  }

}
