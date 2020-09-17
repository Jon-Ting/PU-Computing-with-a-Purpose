/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        // Initialization of variables
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        double[] s = new double[n];
        int cumSum = 0;
        int idx = 0;

        // Define cumulative sums
        for (int i = 0; i < n; i++) {
            cumSum = cumSum + Integer.parseInt(args[i + 1]);
            s[i] = cumSum;
        }

        // Sample from discrete distribution
        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * (s[n - 1]));  // Pick r randomly
            for (int k = 0; k < n; k++) {  // Find unique index
                if (r < s[k]) {
                    idx = k + 1;
                    break;
                }
            }
            System.out.print(idx + " ");  // Print out the index
        }

        System.out.println();  // Print new line in the end
    }
}
