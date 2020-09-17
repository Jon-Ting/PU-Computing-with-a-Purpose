/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class CMYKtoRGB {
    public static void main(String[] args) {
        // Inputs in CMYK
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        // Conversion to RGB
        double white = 1 - black;
        long red = Math.round(255 * white * (1 - cyan));
        long green = Math.round(255 * white * (1 - magenta));
        long blue = Math.round(255 * white * (1 - yellow));

        // Printing outputs in RGB
        System.out.println("red\t= " + red);
        System.out.println("green\t= " + green);
        System.out.println("blue\t= " + blue);
    }
}
