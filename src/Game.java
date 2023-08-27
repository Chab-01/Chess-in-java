import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game {
  protected static Piece clickedPiece = null;
  protected static Piece targetedPiece = null;
  protected static int latestX;
  protected static int latestY;

  public static void main(String[] args) {
    Board board = new Board();
    JFrame frame = new JFrame("Chess");

    board.resetBoard();
    JPanel panel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.drawBoard(g);
        board.drawPieces(g);
      }
    };

    frame.setSize(816, 839); // Dessa värden för att stämma med
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          clickedPiece = board.getPiece(e.getX()/board.tileSize, e.getY()/board.tileSize);
        } else {
          System.out.println("USE LEFT MOUSE BUTTON!");
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if (e.getX() / board.tileSize > 7 || e.getY() / board.tileSize > 7) {
            System.out.println("OUT OF BOUNDS");
          } else {
            try {
              targetedPiece = board.getPiece(e.getX() / board.tileSize, e.getY() / board.tileSize);
              if (targetedPiece == null) {
                clickedPiece.move(board, e.getX() / board.tileSize, e.getY() / board.tileSize);
                System.out.println("Clicked piece: " + clickedPiece.getPieceType()); 
              } else if (targetedPiece.isWhite() != clickedPiece.isWhite()) {
                clickedPiece.move(board, e.getX() / board.tileSize, e.getY() / board.tileSize);       
                System.out.println("Clicked piecedadadadadadada: " + clickedPiece.getPieceType());         
              }
            } catch (NullPointerException error) {
              System.out.println("Drag a piece!");
            }
          }
          frame.repaint();
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }

    });
    frame.addMouseMotionListener(new MouseMotionListener() {

      @Override
      public void mouseDragged(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if (clickedPiece != null) {
            clickedPiece.setPiecePosition(e.getX(), e.getY());
            frame.repaint();
          }
        }
      }

      @Override
      public void mouseMoved(MouseEvent e) {
      }

    });
    frame.setVisible(true);
  }
}
