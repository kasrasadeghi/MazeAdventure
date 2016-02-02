package kaz.mazegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kasra on 2/2/2016.
 */
public class Maze {
    Block[][] blockGrid;

    public Maze(String fileName) {
        blockGrid = readMap(fileName);
    }

    public int getRows() {
        return blockGrid.length;
    }

    public int getCols() {
        return blockGrid[0].length;
    }

    public Block getBlock(int i, int j) {
        return blockGrid[i][j];
    }

    protected Block[][] readMap(String fileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> rows = new ArrayList<>();
        while (fileScanner.hasNext())
            rows.add(fileScanner.nextLine());
        Block[][] output = new Block[rows.size()][];

        for (int j = 0; j < rows.size(); ++j){
            output[j] = new Block[rows.get(j).length()];
            for (int i = 0; i < rows.get(j).length(); ++i)
                output[j][i] = blockCheck(rows.get(j).charAt(i));
        }

        return output;
    }

    //maybe have some way of adding other block types? maybe a block checker method?
    protected Block blockCheck(char c) {
        switch(c) {
            case 'O': return Block.AIR;
            case 'I': return Block.WALL;
            default:  return Block.GROUND;
        }
    }
}

