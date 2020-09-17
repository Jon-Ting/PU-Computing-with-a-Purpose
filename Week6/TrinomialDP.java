/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {

        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        long[][] coef = new long[n + 1][2 * n + 1];
        coef[0][n] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                int left = j - 1;
                int right = j + 1;
                if (left < 0) left += 1;
                else if (right >= 2 * n + 1) right -= 1;
                coef[i][j] = coef[i - 1][left] + coef[i - 1][j] + coef[i - 1][right];
                // StdOut.print(coef[i][j] + " ");  // Debug
            }
            // StdOut.println();  // Debug
        }
        return coef[n][n + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
