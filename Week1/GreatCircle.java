/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        // Inputs and constant
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double r = 6371.0;  // Mean radius of the Earth (km)

        // Computation of distance using Haversine formula
        double firstTerm = Math.sin((x2 - x1) / 2) * Math.sin((x2 - x1) / 2);
        double secondTerm = Math.cos(x1) * Math.cos(x2) * Math.sin((y2 - y1) / 2) * Math
                .sin((y2 - y1) / 2);
        double dist = 2 * r * Math.asin(Math.sqrt(firstTerm + secondTerm));
        System.out.println(dist + " kilometers");
    }
}
