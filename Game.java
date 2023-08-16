import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {
  public static void main(String[] args) {
    Board board = new Board();
    JFrame frame = new JFrame("Chess");

    JPanel panel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.drawBoard(g);
        try {
          board.drawPieces(g);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    };

    frame.setSize(816, 839); // Dessa värden för att stämma med
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.setVisible(true);
  }

  public static void drawPieces(Graphics g) {

  }
}
