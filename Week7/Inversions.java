/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) if (j > i && a[j] < a[i]) counter++;
        }
        return counter;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        // Generate list without permutation
        double start = System.currentTimeMillis() / 1000.0;
        int[] permList = new int[n];
        for (int i = 0; i < n; i++) permList[i] = i;

        // Introduce permutations
        int idx = n - 1;
        long counter = 0;
        while (counter < k) {
            if (permList[idx] > permList[idx - 1]) {
                int tmp = permList[idx];
                permList[idx] = permList[idx - 1];
                permList[idx - 1] = tmp;
                counter = count(permList);
                // StdOut.println(counter);  // Debug
            }
            idx--;
            if (idx == 0) idx += (n - 1);
            double now = System.currentTimeMillis() / 1000.0;
            // if (now - start > 12) break;
        }
        return permList;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] permList = generate(n, k);
        for (int i = 0; i < n; i++) StdOut.print(permList[i] + " ");
        StdOut.println();
    }
}
