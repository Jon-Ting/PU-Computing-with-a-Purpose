/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int maxSize = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {  // When "1" is found

                    // Initialize variables
                    boolean areOnes = true;
                    int currSize = 1;

                    // Repeat as long as the block are "1"s
                    while (areOnes) {
                        if (i + currSize >= a.length || j + currSize >= a.length) break;
                        for (int x = i; x <= i + currSize; x++) {
                            for (int y = j; y <= j + currSize; y++) {
                                if (x == i && y == j) continue;  // Skip the first case
                                if (a[x][y] != 1) {
                                    areOnes = false;
                                    break;
                                }
                            }
                            if (!areOnes) break;
                        }
                        if (!areOnes) break;
                        else currSize++;  // Increase the counter if all entries are "1";
                    }
                    if (currSize > maxSize) maxSize = currSize;
                    // StdOut.println(maxSize);  // Debug
                }
            }
        }
        return maxSize;
    }


    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] sqMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sqMat[i][j] = StdIn.readInt();
                // StdOut.println(sqMat[i][j]); // Debug
            }
        }
        /* int[][] sqMat = {
                { 0, 1, 1, 0, 1, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1 }
        };
        int[][] sqMat = {
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }
        };
        */  // Debug
        StdOut.println(size(sqMat));

        /*  // Generate data files
        StdOut.println("6\n0  1  1  0  1  1\n1  1  0  1  0  1\n0  1  1  1  0  1\n1  1  1  1  1  0"
                               + "\n1  1  1  1  1  1\n0  0  0  0  1  1");
        StdOut.println("7\n0  1  1  0  1  1  1\n1  1  0  1  1  1  1\n0  1  1  1  1  1  1\n1  1  1"
                               + "  1  1  0  1\n1  1  1  1  1  1  0\n1  1  1  1  0  1  1\n1  1  1  1  0  1  1");
         */
    }
}
