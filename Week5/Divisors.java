/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        while (absB != 0) {
            int tmp = absA;
            absA = absB;
            absB = tmp % absB;
        }
        return absA;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        int lcFactor;
        if (a == 0 && b == 0) lcFactor = 0;
        else {
            int tmp = Math.abs(b) / gcd(a, b);
            lcFactor = Math.abs(a) * tmp;
        }
        return lcFactor;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        boolean bool;
        if (gcd(a, b) == 1) bool = true;
        else bool = false;
        return bool;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int numInt = 0;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (areRelativelyPrime(n, i)) numInt++;
            }
        }
        return numInt;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
