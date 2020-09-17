/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class Minesweeper {
    public static void main(String[] args) {

        // Set and initialize variables
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] grid = new int[m + 2][n + 2];  // Create an extended m * n grid
        Arrays.stream(grid).forEach(arr -> Arrays.fill(arr, 0));  // Fill with 0
        int[] rList = new int[2 * k];
        int rNum = 0;

        // Choose mine locations
        while (rNum < k) {
            boolean isRepeat = false;
            int r = (int) (Math.random() * m * n);
            // System.out.print(r + ", ");
            if (rNum > 0) {  // Check for repetition after the first mine
                for (int b = 0; b < rNum; b++) {
                    if (rList[b] == r) {
                        isRepeat = true;
                        break;
                    }
                }
            }
            if (isRepeat) continue;
            rList[rNum] = r;
            rNum++;

            // Record the mine's position based on the random number
            int x = r / n;
            int y = r - n * x;
            grid[x + 1][y + 1] = 9;
        }


        // Print out the rest of the grid
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (grid[i][j] != 9) {  // If the entry is not a mine
                    int counter = 0;  // Reset the counter
                    for (int r = -1; r <= 1; r++) {
                        for (int c = -1; c <= 1; c++) {
                            if (grid[i + r][j + c] == 9)
                                counter++;  // Update counter with each mine
                        }
                    }
                    System.out.print(counter);  // Print the number of neighboring mines
                }
                else
                    System.out.print("*");  // Print out the mine
                System.out.print("  ");  // Two spacing between each entry in a row
            }
            System.out.println();  // New line after each row
        }
    }
}
