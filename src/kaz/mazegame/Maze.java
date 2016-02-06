package kaz.mazegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kasra on 2/2/2016.
 */
public class Maze {

    private BLOCK[][] blockGrid;
    private Loc advStart;

    public Maze(String fileName) {
        blockGrid = readMap(fileName);
    }
    public int getRows() {
        return blockGrid.length;
    }
    public int getCols() {
        return blockGrid[0].length;
    }
    public BLOCK getBlock(int i, int j) {
        return blockGrid[i][j];
    }
    public BLOCK getBlock(Loc l) {
        return blockGrid[l.getR()][l.getC()];
    }
    public Loc getAdvStart() {
        return advStart;
    }

    protected BLOCK[][] readMap(String fileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> rows = new ArrayList<>();
        while (fileScanner.hasNext())
            rows.add(fileScanner.nextLine());
        BLOCK[][] output = new BLOCK[rows.size()][];

        for (int j = 0; j < rows.size(); ++j) {
            output[j] = new BLOCK[rows.get(j).length()];
            for (int i = 0; i < rows.get(j).length(); ++i) {
                output[j][i] = blockCheck(rows.get(j).charAt(i));
                if (output[j][i] == BLOCK.ADVENTURER_START) 
                    advStart = new Loc(j, i);
            }
        }

        return output;
    }

    //maybe have some way of adding other block types? maybe a block checker method?
    protected BLOCK blockCheck(char c) {
        switch(c) {
            case 'O': return BLOCK.AIR;
            case 'I': return BLOCK.WALL;
            case 'A': return BLOCK.ADVENTURER_START;
            default:  return BLOCK.GROUND;
        }
    }
}

