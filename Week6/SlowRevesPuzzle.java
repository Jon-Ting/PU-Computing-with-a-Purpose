/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class SlowRevesPuzzle {

    // Solves Reve's puzzle
    private static void reves(int n, String from, String tmp1, String tmp2, String to) {

        if (n == 0) return;  // Base case
        if (n == 1) {
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }

        reves(n - 2, from, tmp2, to, tmp1);  // Start: from, Dest: tmp
        StdOut.println("1Move disc " + (n - 1) + " from " + from + " to " + tmp2);
        StdOut.println("2Move disc " + n + " from " + from + " to " + to);
        StdOut.println("3Move disc " + (n - 1) + " from " + tmp2 + " to " + to);
        reves(n - 2, tmp1, tmp2, from, to);  // Start: tmp, Dest: to
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");  // Start: A, Dest: D
    }
}
