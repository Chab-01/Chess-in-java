import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Board { // MÅSTE MULTIPLICERA TILE X OCH Y MED TILESIZE FÖR O FÅ RÄTT POSITION
  private int tileSize = 100;
  private BufferedImage img;
  protected ArrayList<Piece> pieces = new ArrayList<>();
  private ArrayList<BufferedImage> imgs = new ArrayList<>();

  protected void resetBoard() {
    pieces.clear();
    // White pieces
    pieces.add(new King(4, 0, true, Piece.PieceType.W_KING));
    pieces.add(new Queen(3, 0, true, Piece.PieceType.W_QUEEN));
    pieces.add(new Bishop(2, 0, true, Piece.PieceType.W_BISHOP));
    pieces.add(new Tower(0, 0, true, Piece.PieceType.W_TOWER));
    pieces.add(new Knight(1, 0, true, Piece.PieceType.W_KNIGHT));
    pieces.add(new Bishop(5, 0, true, Piece.PieceType.W_BISHOP));
    pieces.add(new Tower(7, 0, true, Piece.PieceType.W_TOWER));
    pieces.add(new Knight(6, 0, true, Piece.PieceType.W_KNIGHT));
    for (int i = 0; i < 8; i++) {
      pieces.add(new Pawn(i, 1, true, Piece.PieceType.W_PAWN));
    }

    // Black pieces
    pieces.add(new King(4, 7, false, Piece.PieceType.B_KING));
    pieces.add(new Queen(3, 7, false, Piece.PieceType.B_QUEEN));
    pieces.add(new Bishop(2, 7, false, Piece.PieceType.B_BISHOP));
    pieces.add(new Tower(0, 7, false, Piece.PieceType.B_TOWER));
    pieces.add(new Knight(1, 7, false, Piece.PieceType.B_KNIGHT));
    pieces.add(new Bishop(5, 7, false, Piece.PieceType.B_BISHOP));
    pieces.add(new Tower(7, 7, false, Piece.PieceType.B_TOWER));
    pieces.add(new Knight(6, 7, false, Piece.PieceType.B_KNIGHT));
    for (int i = 0; i < 8; i++) {
      pieces.add(new Pawn(i, 6, false, Piece.PieceType.B_PAWN));
    }

  }

  public void drawBoard(Graphics g) {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if ((row + col) % 2 == 0) {
          g.setColor(Color.white);
        }
        // if (row == 5 && col == 7) { // FÖR ATT VÄLJA TILE
        // g.setColor(Color.red);
        // }
        else {
          g.setColor(Color.darkGray);
        }
        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
      }
    }
  }

  /*
   * private int[] getTile(int x, int y) {
   * for (int row = 0; row < 8; row++) {
   * for (int col = 0; col < 8; col++) {
   * if (row == x && col == y) {
   * int coordinates[] = { row, col };
   * return coordinates;
   * }
   * 
   * }
   * }
   * return null;
   * 
   * }
   */

  protected void drawPieces(Graphics g)    {
    String imgPaths[] = { "wking.png", "bking.png", "bbishop.png", "bknight.png", "bpawn.png", "bqueen.png",
        "btower.png",
        "wbishop.png", "wknight.png", "wpawn.png", "wqueen.png", "wtower.png" };
    for (String imagePath : imgPaths) {
      try {
        img = ImageIO.read(new File("img\\" + imagePath));
      } catch (IOException e) {
        System.out.println("Failed to read image");
      }
      imgs.add(img);
    }

    for (Piece p : pieces) {
      int x = p.getPiecePositionX();
      int y = p.getPiecePositionY();

      Piece.PieceType pieceType = p.getPieceType();
      int pieceIndex = pieceType.ordinal();
      BufferedImage pieceImage = imgs.get(pieceIndex);

      g.drawImage(pieceImage, x * tileSize, y * tileSize, tileSize, tileSize, null);
    }
  }

  protected Piece getPiece (int x, int y) {
    for (Piece p : pieces) {
      if (x/tileSize == p.getPiecePositionX() && y/tileSize == p.getPiecePositionY()) {
        return p;
      } 
    }
    return null;
  }
}
