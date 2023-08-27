
public abstract class Piece {
  private int x;
  private int y;
  private PieceType type;
  private boolean isWhite = false;
  
  public enum PieceType {
    W_KING, B_KING, B_BISHOP, B_KNIGHT, B_PAWN, B_QUEEN, B_TOWER,
    W_BISHOP, W_KNIGHT, W_PAWN, W_QUEEN, W_TOWER, 
  }

  public Piece(int x, int y, boolean isWhite, PieceType type) {
    this.x = x;
    this.y = y;
    this.isWhite = isWhite;
    this.type = type;
  }

  public void setPiecePosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getPiecePositionX() {
    return this.x;
  }

  public int getPiecePositionY() {
    return this.y;
  }

  public PieceType getPieceType() {
    return this.type;
  }

  public boolean isWhite() {
    return this.isWhite;
  }

  public abstract void move(Board board, int start, int end);

}
