/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {

        // Set up the canvas
        // StdDraw.enableDoubleBuffering();
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // Read in information in the regions
        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int numVert = StdIn.readInt();

            // Draw the polygon
            double[] xList = new double[numVert];
            double[] yList = new double[numVert];
            for (int i = 0; i < numVert; i++) {
                double x = StdIn.readDouble();
                double y = StdIn.readDouble();
                xList[i] = x;
                yList[i] = y;
            }
            StdDraw.polygon(xList, yList);
        }
        StdDraw.show();
    }
}
