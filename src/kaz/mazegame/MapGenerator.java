package kaz.mazegame;

import org.jetbrains.annotations.Contract;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by KASRA on 2/3/2016.
 *
 * An attempt at learning cellular automata.
 */
public class MapGenerator {
    private static final int DEATH_LIMIT = 3;
    private static final int BIRTH_LIMIT = 4;
    private static final int STEP_COUNT = 7;

    public static void generateMap(int w, int h, String filename) {
        boolean[][] cellmap = initBitMap(w, h);


        for (int i = 0; i < STEP_COUNT; ++i)
            cellmap = doStep(cellmap);
        printMap(cellmap);
    }

    private static void printMap(boolean[][] map) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("map.txt", "UTF-8");
            for (int i = 0; i < map.length; ++i) {
                for (int j = 0; j < map[0].length; ++j) {
                    if ( i == map.length/2 && j == map[0].length/2)
                        writer.print('A');
                    else writer.print((map[i][j])? 'I': ' ');
                }
                writer.println();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static boolean[][] initBitMap(int r, int c) {
        boolean[][] output = new boolean[r][c];
        double probability = 0.40;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                output[i][j] = Math.random() < probability;
            }
        }

        return output;
    }

    @Contract(pure = true)
    public static boolean[][] doStep(boolean[][] oldMap){
        boolean[][] newMap = new boolean[oldMap.length][oldMap[0].length];
        //Loop over each row and column of the map
        for(int x=0; x<oldMap.length; x++){
            for(int y=0; y<oldMap[0].length; y++){
                int nbs = countAlive(oldMap, x, y);
                //The new value is based on our simulation rules
                //First, if a cell is alive but has too few neighbours, kill it.
                if(oldMap[x][y])
                    newMap[x][y] = !(nbs < DEATH_LIMIT);
                else newMap[x][y] = nbs > BIRTH_LIMIT;
            }
        }
        return newMap;
    }

    @Contract(pure = true)
    private static int countAlive(boolean[][] map, int r, int c){
        int count = 0;
        for (int i = -1; i < 2; ++i)
            for (int j = -1; j < 2; ++j) {
                int nr = r + i; //neighbouring row
                int nc = c + j; //neighbouring column
                if(i == 0 && j == 0){
                } else if (nr < 0 ||
                        nc < 0 ||
                        nr >= map.length ||
                        nc >= map[0].length){
                    count = count + 1;
                } else if (map[nr][nc])
                    count = count + 1;
            }
        return count;
    }
}
