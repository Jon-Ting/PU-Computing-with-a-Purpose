/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {

        /*
        StdOut.println("1 1 1 1 2 1 2 1 1 2");
        StdOut.println("2 2 2 2 1 2 1 2 2 1");
        StdOut.println("3 2 6 2 4 3 2 1 2 2 1 3 2 3 2 2");
         */  // Make example data files

        // Set and initialize variables
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m];
        int inpNum = 0;
        double shannon = 0.0;
        double term = 0;

        // Fill in the frequency array with the inputs
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            freq[i - 1]++;
            inpNum++;
        }

        // Compute and print Shannon entropy
        for (int i = 0; i < freq.length; i++) {
            double prop = (double) freq[i] / inpNum;
            if (prop == 0) term = 0;
            else term = prop * Math.log10(prop) / Math.log10(2);
            shannon += term;
        }
        StdOut.printf("%.4f", -shannon);
        StdOut.println();
    }
}
