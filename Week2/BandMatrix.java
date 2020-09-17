/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {

        // Input and initialization
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        // Go through each entry and print them out
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(j - i) > width) System.out.print(0);
                else System.out.print("*");
                if (j == n - 1) System.out.println();
                else System.out.print("  ");
            }
        }
    }
}
