package kaz.mazegame;

import javax.swing.*;

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

            add(new GamePanel());
            pack();
            setVisible(true);
        }
    }
}
