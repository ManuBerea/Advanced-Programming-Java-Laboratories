package lab6.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20, nrOfClicks = 0;
    BufferedImage image; //the offscreen image
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
              //  frame.addImage(frame.canvas.image);
               // repaint();
                nrOfClicks++;
            }
        });

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        g.drawImage(image, 0, 0, this);

        //paintSticks(g);

     //   paintStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        Random randomBool = new Random(); // creating Random object

        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;

            if(randomBool.nextBoolean()) {
                g.setStroke(new BasicStroke(5));
            }
            g.drawLine(x1, y1, x2, y2);
            g.setStroke(new BasicStroke(1));
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY + boardHeight;
            int x2 = x1;
            int y2 = padY;

            if(randomBool.nextBoolean()) {
                g.setStroke(new BasicStroke(5));
            }
            g.drawLine(x1, y1, x2, y2);
            g.setStroke(new BasicStroke(1));
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void paintStones(Graphics2D g) {
    }

    private void drawStone(int x, int y) {

    }


    private Color getColorType() {
        if (nrOfClicks % 2 != 0) {
            //player 1
            return new Color(215, 5, 5);
        }
        //player 2
        return new Color(4, 54, 218);
    }

}
