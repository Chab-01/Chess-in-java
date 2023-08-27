
public class Queen extends Piece{
  public Queen(int x, int y, boolean white, PieceType type) {
    super(x, y, white, type);
  }

  @Override
  public void move(int start, int end) {
    setPiecePosition(start, end);
  }

}
