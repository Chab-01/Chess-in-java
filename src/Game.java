import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game {
  private static Piece clickedPiece = null;
  private static int latestX;
  private static int latestY;

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
          clickedPiece = board.getPiece(e.getX(), e.getY());
          if (clickedPiece == null) {
            return;
          }
          latestX = clickedPiece.getPiecePositionX();
          latestY = clickedPiece.getPiecePositionY();
        } else {
          System.out.println("USE LEFT MOUSE BUTTON!");
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if (clickedPiece == null) {
            System.out.println("Select a piece to drag");
          }
          if (e.getX() / 100 > 7 || e.getY() / 100 > 7) {
            clickedPiece.setPiecePosition(latestX, latestY);
            System.out.println("OUT OF BOUNDS");
          } else {
            try {
              clickedPiece.move(e.getX() / 100, e.getY() / 100);
            } catch (NullPointerException error) {
              
            }
          }

        }
        frame.repaint();
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
        if (clickedPiece != null) {
          clickedPiece.setPiecePosition(e.getX(), e.getY());
          frame.repaint();
        }
      }

      @Override
      public void mouseMoved(MouseEvent e) {
      }

    });
    frame.setVisible(true);
  }
}
