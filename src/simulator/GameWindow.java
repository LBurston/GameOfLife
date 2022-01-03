package simulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame {

    // Colours for dead and alive cells
    private static final Color DEAD_COLOUR = Color.darkGray;
    private static final Color ALIVE_COLOUR = Color.orange;
    private final String STEP_LABEL = "Step: ";
    private JLabel stepLabel;
    private GridView gridView;

    public GameWindow(int width, int height) {
        setTitle("Conway's Game Of Life");
        setLocation(150, 100);
        stepLabel = new JLabel(STEP_LABEL, JLabel.LEFT);
        gridView = new GridView(width,height);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(stepLabel, BorderLayout.NORTH);
        container.add(gridView, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton pause_play = new JButton("Pause/Play");
        JButton nextStep = new JButton("Next Step");
        JButton restart = new JButton("Restart");
        buttonPanel.add(pause_play);
        buttonPanel.add(nextStep);
        buttonPanel.add(restart);
        container.add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }


    private class GridView extends JPanel {
        private final int GRID_SCALE_FACTOR = 6;

        private int gridHeight, gridWidth;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image gridImage;

        public GridView(int width, int height) {
            gridWidth = width;
            gridHeight = height;
            size = new Dimension(0,0);
        }

        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_SCALE_FACTOR,
                                gridHeight * GRID_SCALE_FACTOR);
        }

        public void prepareGrid() {
            if(!size.equals(getSize())) {
                size = getSize();
                gridImage = gridView.createImage(size.width, size.height);
                g = gridImage.getGraphics();

                xScale = size.width / gridWidth;
                if(xScale < 1) { xScale = GRID_SCALE_FACTOR; }
                yScale = size.height / gridHeight;
                if(yScale < 1) { yScale = GRID_SCALE_FACTOR; }
            }
        }

        public void drawCell(int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale-1, yScale-1);
        }

        public void paintGrid() {
            if(gridImage != null) {
                Dimension currentSize = getSize();
                if(size.equals(currentSize)) {
                    g.drawImage(gridImage, 0, 0, null);
                } else {
                    g.drawImage(gridImage, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
    }
}
