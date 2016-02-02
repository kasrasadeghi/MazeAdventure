package kaz.mazegame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static JFrame frame;
    public static Game game;

    public static void main(String[] args) {
        game = new Game("map.txt");
        SwingUtilities.invokeLater(() ->  guiInit());
    }

    public static void guiInit() {
        frame = new KFrame();
    }

    static class KFrame extends JFrame {
        KFrame() {
            super("Maze Adventure");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GamePanel gp = new GamePanel();
            addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {}
                public void keyPressed(KeyEvent keyEvent) {
                    gp.handleKeyEvent(keyEvent);
                }
                public void keyReleased(KeyEvent keyEvent) {}
            });
            add(gp);
            
            pack();
            setVisible(true);
        }
    }
}
