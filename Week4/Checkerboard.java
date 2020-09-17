/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {

        // Set up variables and canvas
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        Color c = Color.lightGray;
        if (n % 2 == 0) c = Color.blue;

        // Draw each squares
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (c == Color.blue) c = Color.lightGray;
                else c = Color.blue;
                StdDraw.setPenColor(c);
                StdDraw.filledSquare(i + 0.5, j + 0.5, (double) n / (n * 2));
                // StdDraw.text(i + 0.5, j + 0.5, String.format("%d %d", i, j));  // Debug
            }
            if (n % 2 == 0) {  // If even number, invert color at the end of each line
                if (c == Color.blue) c = Color.lightGray;
                else c = Color.blue;
            }
        }
    }
}
