package kaz.mazegame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasra on 2/1/2016.
 */
public class GamePanel extends JPanel {
    private Maze maze;

    private static int BLOCK_SIZE = 30;

    private int r, c;

    public GamePanel() {
        maze = Main.game.getMaze();
        r = maze.getRows();
        c = maze.getCols();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public Dimension getPreferredSize() {
        return new Dimension(c*BLOCK_SIZE + 1, r*BLOCK_SIZE + 1);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                paintBlock(g, maze.getBlock(i, j), i, j);


    }

    protected void paintBlock(Graphics g, Block b, int i, int j) {
        switch(b) {
            case AIR:
                g.setColor(Color.CYAN);
                break;
            case WALL:
                g.setColor(Color.GRAY);
                break;
            case GROUND:
                g.setColor(Color.GREEN);
                break;
        }
        g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }
}
