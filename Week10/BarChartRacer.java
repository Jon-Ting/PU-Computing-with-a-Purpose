/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {
    public static void main(String[] args) {

        // Read command line arguments
        In racerFile = new In(args[0]);
        int k = Integer.parseInt(args[1]);

        // Set up the bar chart
        // StdAudio.loop("piano.wav");
        String title = racerFile.readLine();
        String xAxisLabel = racerFile.readLine();
        String dataSource = racerFile.readLine();
        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // Loop through each line of the bar-chart-racer file until the end
        int recordNum = 0;
        while (racerFile.hasNextLine()) {

            // Reset the chart when blank line is found
            if (racerFile.readLine().equals("")) {
                recordNum = Integer.parseInt(racerFile.readLine());
                chart.reset();
            }

            // Read in the data for each group and sort in descending order
            Bar[] bars = new Bar[recordNum];
            for (int i = 0; i < recordNum; i++) {
                String dataLine = racerFile.readLine();
                String time = dataLine.split(",")[0];
                chart.setCaption(time);
                String name = dataLine.split(",")[1];
                int value = Integer.parseInt(dataLine.split(",")[3]);
                String category = dataLine.split(",")[4].replace("\n", "");
                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars, Collections.reverseOrder());

            // Add the first k bars to the chart and draw it
            for (int i = 0; i < k; i++)
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            chart.draw();
            StdDraw.show();
            StdDraw.pause(85);
            StdDraw.clear();
        }
    }
}
