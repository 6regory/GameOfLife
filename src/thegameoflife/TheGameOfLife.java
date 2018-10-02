/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegameoflife;


/**
 *
 * @author Greg
 */
public class TheGameOfLife {

    static int rows = 10;
    static int cols = 10;
    public static boolean[][] grid = new boolean[rows][cols];

    /**
     * @param args the command line arguments
     */
    

    public static void printBoard(boolean[][] board) {
        for (int c = 0; c < board.length; c++) {
            for (int r = 0; r < board[0].length; r++) {
                if (board[r][c] == false) {
                    System.out.print(" 0 ");
                } else {
                    System.out.print(" 1 ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static boolean[][] update() {
        boolean[][] newGrid = new boolean[rows][cols];

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                newGrid[y][x] = grid[y][x];
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int neighbours = checkNeighbour(i, j);
                if (neighbours < 2) {
                    newGrid[i][j] = false;
                } else if (neighbours > 3) {
                    newGrid[i][j] = false;
                } else if (neighbours == 3 && newGrid[i][j] == false) {
                    newGrid[i][j] = true;
                } 
            }
        }
        grid = newGrid;
        return grid;
    }

    public static int checkNeighbour(int x, int y) {
        int numNeighbours = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    try {
                        if ((i == 0) && (j == 0)) {
                        } else {
                            if (grid[x + i][y + j]) {
                                numNeighbours++;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException exception) {

                    }
                }
            }
        
        return numNeighbours;
    }
}
