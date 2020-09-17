/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;

        for (int i = 0; i < trials; i++) {

            // Initialize variables
            int dist = 0;
            int x = 0;
            int y = 0;

            // Start walking randomly
            while (dist != r) {

                // Choosing direction
                double rand = Math.random();
                if (rand <= 0.25) x++;
                else if (rand <= 0.50) x--;
                else if (rand <= 0.75) y++;
                else if (rand <= 1.00) y--;

                // Measuring Manhattan distance and update steps taken
                dist = Math.abs(x) + Math.abs(y);
                totalSteps++;
            }
        }
        // Print out the average number of steps taken
        double avgSteps = (double) totalSteps / trials;
        System.out.println("average number of steps = " + avgSteps);
    }
}
