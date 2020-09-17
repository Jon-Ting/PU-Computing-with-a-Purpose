/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

        // Initialize variables
        long a3 = 0;
        long c3 = 0;
        double b = 0;
        double d = 0;

        // Find first pair of numbers (a, b)
        for (long a = 1; a < n; a++) {
            a3 = a * a * a;
            if (a3 > n) break;  // Stop if a^3 exceeds n
            b = Math.cbrt(n - a3);
            if (b == (int) b) break;  // Found a valid b
        }
        long b3 = (long) (b * b * b);

        // Find second pair of numbers (c, d)
        if (n > Math.pow(2, 62)) {
            for (long c = (long) Math.cbrt(a3); c < n; c++) {
                c3 = c * c * c;
                if (c3 > n) break;  // Stop if c^3 exceeds n
                d = Math.cbrt(n - c3);
                if (d == (int) d) break;  // Found a valid d
            }
        }
        else {
            for (long c = (long) Math.cbrt(a3) + 1; c < n; c++) {
                c3 = c * c * c;
                if (c3 > n) break;  // Stop if c^3 exceeds n
                d = Math.cbrt(n - c3);
                if (d == (int) d) break;  // Found a valid d
            }
        }
        long d3 = (long) (d * d * d);

        // Return true if (a, b, c, d) match the condition and vice versa
        return (a3 + b3 == c3 + d3) && (b3 != c3);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
