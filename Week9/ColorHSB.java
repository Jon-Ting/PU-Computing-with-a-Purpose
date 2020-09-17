/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {

    private final int hue;
    private final int sat;
    private final int bri;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h >= 360 || s > 100 || b > 100)
            throw new IllegalArgumentException("component out of range!");
        hue = h;
        sat = s;
        bri = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        String colorStr = String.format("(%d, %d, %d)", hue, sat, bri);
        return colorStr;
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (sat == 0 || bri == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("ColorHSB object is null!");
        int dist = (int) (
                Math.min(Math.pow(that.hue - hue, 2), Math.pow(360 - Math.abs(that.hue - hue), 2))
                        + Math.pow(that.sat - sat, 2) + Math.pow(that.bri - bri, 2));
        return dist;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB thisColor = new ColorHSB(h, s, b);
        int minDist = Integer.MAX_VALUE;
        ColorHSB targetColor = thisColor;
        String targetColorName = "";

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB thatColor = new ColorHSB(h2, s2, b2);
            // StdOut.println(thatColor);  // Debug
            int sqDist = thisColor.distanceSquaredTo(thatColor);
            if (sqDist < minDist) {
                minDist = sqDist;
                targetColorName = colorName;
                targetColor = thatColor;
            }
        }
        StdOut.println(targetColorName + " " + targetColor);
    }
}
