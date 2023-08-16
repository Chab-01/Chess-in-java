
public abstract class Piece {
  private int x;
  private int y;
  private String name;
  private boolean isWhite = false;
  private boolean isKilled = false;

  public Piece(int x, int y, boolean isWhite, String name) {
    this.x = x;
    this.y = y;
    this.isWhite = isWhite;
    this.name = name;
  }

  public void setPiece(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getPiecePositionX() {
    return this.x;
  }

  public int getPiecePositionY() {
    return this.y;
  }

  public String getName() {
    return this.name;
  }

  public boolean isKilled() {
    return this.isKilled;
  }

  public boolean isWhite() {
    return this.isWhite;
  }

  public abstract void Move(int start, int end);

}
