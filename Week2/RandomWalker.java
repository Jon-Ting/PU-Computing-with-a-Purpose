/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {

        // Initialize variables
        int r = Integer.parseInt(args[0]);
        int dist = 0;
        int x = 0;
        int y = 0;
        int steps = 0;

        // Start walking randomly
        System.out.println("(" + x + ", " + y + ")");
        while (dist != r) {

            // Choosing direction
            double rand = Math.random();
            if (rand <= 0.25) x++;
            else if (rand <= 0.50) x--;
            else if (rand <= 0.75) y++;
            else if (rand <= 1.00) y--;

            // Measuring Manhattan distance and update steps taken
            dist = Math.abs(x) + Math.abs(y);
            steps++;

            // Print out coordinates (and steps if end point reached)
            System.out.println("(" + x + ", " + y + ")");
            if (dist + 1 == r + 1) System.out.println("steps = " + steps);
        }
    }
}
