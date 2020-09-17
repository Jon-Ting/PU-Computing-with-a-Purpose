/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    // Solves towers of Hanoi problem
    private static int hanoi(int n, String from, String tmp, String to, int k, int counter) {
        if (n == 0) return counter;  // Base case
        if (counter > 18433) return counter;  // Jump out if limit exceeded
        counter = hanoi(n - 1, from, to, tmp, k, counter);  // Start: from, Dest: tmp, Aux: to
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        counter++;
        counter = hanoi(n - 1, tmp, from, to, k, counter);  // Start: tmp, Dest: to, Aux: from
        return counter;
    }

    // Solves Reve's puzzle
    private static int reves(int n, String from, String tmp1, String tmp2, String to, int counter) {
        if (n == 0) return counter;  // Base case
        if (counter > 18433) return counter;  // Jump out if limit exceeded
        if (n == 1) {
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            counter++;
            return counter;
        }
        counter = reves(n - 2, from, tmp2, to, tmp1, counter);  // Start: from, Dest: tmp
        StdOut.println("Move disc " + (n - 1) + " from " + from + " to " + tmp2);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        StdOut.println("Move disc " + (n - 1) + " from " + tmp2 + " to " + to);
        counter += 3;
        counter = reves(n - 2, tmp1, tmp2, from, to, counter);  // Start: tmp, Dest: to
        return counter;
    }

    // Frame/Stewart algorithm
    private static void fraste(int n, String from, String tmp1, String tmp2, String to) {
        int k = n + 1 - (int) Math.round(Math.sqrt(2 * n + 1));
        int counter = 0;
        counter = reves(k, from, tmp2, to, tmp1, counter);  // Start: from, Dest: tmp1
        // StdOut.println("* Moved k discs to B");  // Debug
        counter = hanoi(n - k, from, tmp2, to, k, counter);  // Start: A, Dest: D, Aux: C
        // StdOut.println("* Moved n-k discs to D");  // Debug
        counter = reves(k, tmp1, tmp2, from, to, counter);  // Start: tmp1, Dest: to
        // StdOut.println("* Moved k discs to D");  // Debug
        // StdOut.println("\nk: " + k);
        // StdOut.println("Total move(s): " + counter);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String from = "A";
        String tmp1 = "B";
        String tmp2 = "C";
        String to = "D";
        fraste(n, from, tmp1, tmp2, to);  // Start: A, Dest: D

        /*
        int moves = 0;
        moves = hanoi(16, "A", "B", "C", 1, moves);
        moves = reves(n, "A", "B", "C", "D", moves);
        StdOut.println(moves);
        */    // Debug
    }
}
