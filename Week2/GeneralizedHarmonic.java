/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {

        // Input and initialization
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double cumSum = 0;

        // Cumulatively sums up the terms
        for (int i = 1; i <= n; i++) {
            double term = 1 / Math.pow(i, r);
            cumSum = cumSum + term;
        }

        // Print out the harmonic number
        System.out.println(cumSum);
    }
}
