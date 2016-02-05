package kaz.mazegame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static JFrame frame;
    public static Game game;
    public static final int[] monsterCount = {0};

    public static void main(String[] args) {
        String fileName = "map.txt";
        int size = 40;
        MapGenerator bigCave = new MapGenerator();
        bigCave.generateMap(size, size, fileName);
        game = new Game(fileName);
        SwingUtilities.invokeLater(() -> frame = new KFrame());
    }

    static class KFrame extends JFrame {
        KFrame() {
            super("Maze Adventure");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            GamePanel gp = new GamePanel(game);
            addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {}
                public void keyPressed(KeyEvent keyEvent) {
                    gp.handleKeyEvent(keyEvent);
                }
                public void keyReleased(KeyEvent keyEvent) {}
            });

            new Thread() {
                public void run() {
                    while(true) {

                    gp.update();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                }
            }.start();
            add(gp);

            pack();
            setVisible(true);
        }
    }
}
