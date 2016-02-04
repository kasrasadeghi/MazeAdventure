package kaz.mazegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by kasra on 2/1/2016.
 */
public class GamePanel extends JPanel {
    private Maze maze;
    private Game game;

    private final static int BLOCK_SIZE = 25;
    private final static int ADVENTURER_OFFSET = 5;

    private int r, c;

    public GamePanel() {
        game = Main.game;
        maze = game.getMaze();
        r = maze.getRows();
        c = maze.getCols();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void handleKeyEvent(KeyEvent ke) {
        Adventurer adv = game.getAdventurer();
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_W:
                adv.move(DIRECTION.UP);
                break;
            case KeyEvent.VK_A:
                adv.move(DIRECTION.LEFT);
                break;
            case KeyEvent.VK_S:
                adv.move(DIRECTION.DOWN);
                break;
            case KeyEvent.VK_D:
                adv.move(DIRECTION.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                //attack left
                break;
            case KeyEvent.VK_RIGHT:
                //attack right
                break;
            case KeyEvent.VK_UP:
                //attack up
                break;
            case KeyEvent.VK_DOWN:
                //attack down
                break;
        }
        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(c*BLOCK_SIZE + 1, r*BLOCK_SIZE + 1);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                paintBlock(g, maze.getBlock(i, j), i, j);

        paintActors(g);
        paintAdventurer(g, game.getAdventurer());
    }

    protected void paintBlock(Graphics g, BLOCK b, int i, int j) {
        switch(b) {
            case AIR:
                g.setColor(Color.RED);
                break;
            case WALL:
                g.setColor(Color.GRAY);
                break;
            case ADVENTURER_START:
                g.setColor(Color.YELLOW);
                break;
            default:
                g.setColor(Color.BLACK);
                break;
        }
        g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }

    protected void paintActors(Graphics g) {

    }

    protected void paintAdventurer(Graphics g, Adventurer a) {
        g.setColor(Color.WHITE);
        g.fillRect(a.getC() * BLOCK_SIZE + ADVENTURER_OFFSET, a.getR() * BLOCK_SIZE + ADVENTURER_OFFSET,
                BLOCK_SIZE - 2* ADVENTURER_OFFSET, BLOCK_SIZE - 2* ADVENTURER_OFFSET);
    }
}
