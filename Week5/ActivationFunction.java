/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double fx;
        if (x < 0) fx = 0;
        else if (x == 0) fx = 0.5;
        else fx = 1;
        return fx;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double fx;
        fx = 1 / (1 + Math.exp(-x));
        return fx;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) return 1.0;
        else if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) return -1.0;
        double fx;
        fx = (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
        return fx;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else if (x == Double.POSITIVE_INFINITY) return 1.0;
        else if (x == Double.NEGATIVE_INFINITY) return -1.0;
        double fx;
        fx = x / (1 + Math.abs(x));
        return fx;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double fx;
        if (x <= -2) fx = -1;
        else if (x < 0 && x > -2) fx = x + Math.pow(x, 2) / 4;
        else if (x < 2 && x >= 0) fx = x - Math.pow(x, 2) / 4;
        else fx = 1;
        return fx;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        try {
            double x = Double.parseDouble(args[0]);
            // double x = Double.POSITIVE_INFINITY;  // Debug
            StdOut.println("heaviside(" + x + ") = " + heaviside(x));
            StdOut.println("  sigmoid(" + x + ") = " + sigmoid(x));
            StdOut.println("     tanh(" + x + ") = " + tanh(x));
            StdOut.println(" softsign(" + x + ") = " + softsign(x));
            StdOut.println("     sqnl(" + x + ") = " + sqnl(x));
        }
        catch (NumberFormatException ex) {
            StdOut.println(Double.NaN);
        }
    }
}
