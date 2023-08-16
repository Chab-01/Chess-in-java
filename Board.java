import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Board { // MÅSTE MULTIPLICERA TILE X OCH Y MED TILESIZE FÖR O FÅ RÄTT POSITION
  private int boardSize = 100;
  private BufferedImage imageOfPieces;
  private ArrayList<Piece> pieces = new ArrayList<>();


  protected void addPieces() {
    Piece wKing = new King(0, 0, true, "king");
    Piece bKing = new King(5, 5, false, "king");

    pieces.add(wKing);
    pieces.add(bKing);
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
        g.fillRect(col * boardSize, row * boardSize, boardSize, boardSize);
      }
    }
  }

  public int[] getTile(int x, int y) {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (row == x && col == y) {
          int coordinates[] = { row, col };
          return coordinates;
        }

      }
    }
    return null;

  }

  public void drawPieces(Graphics g) throws IOException {
    addPieces();
    int imageIndex = 0;
    imageOfPieces = ImageIO.read(new File("img\\pieces.png"));
    Image imgs[] = new Image[12];
    int ind = 0;
    for (int y = 0; y < 400; y += 200) {
      for (int x = 0; x < 1200; x += 200) {
        imgs[ind] = imageOfPieces.getSubimage(0, 10, 130, 130).getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
        ind++;
      }
    }

    for (Piece p : pieces) {
      if (p.getName().equals("king")) {
          imageIndex = 0;
      } else if (p.getName().equals("queen")) {
          imageIndex = 1;
      } else if (p.getName().equals("bishop")) {
          imageIndex = 2;
      } else if (p.getName().equals("horse")) {
          imageIndex = 3;
      } else if (p.getName().equals("tower")) {
          imageIndex = 4;
      } else if (p.getName().equals("pawn")) {
          imageIndex = 5;
      }
      if (!p.isWhite()) {
          imageIndex += 6;
      }
  
      g.drawImage(imgs[imageIndex], p.getPiecePositionX() * boardSize, p.getPiecePositionY() * boardSize, null);
  }

  }
}
