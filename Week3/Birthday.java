/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {

        // Set and initialize variables
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int numSlot = 3 * n;
        int[] numPeop = new int[trials];

        // Repeat the experiment for trials time
        for (int i = 0; i < trials; i++) {

            boolean notShare = true;
            int j = 0;
            int[] collection = new int[numSlot];

            while (notShare) {
                int bday = (int) (Math.random() * (n - 1));  // Newcomer's birthday
                collection[j] = bday;  // Enter the room
                if (j < 1) {  // Skip checking step if newcomer is the first person
                    j++;
                    continue;
                }
                for (int k = 0; k < j; k++) {  // Check if anyone share newcomer's birthday
                    if (collection[k] == bday) {
                        notShare = false;
                        break;
                    }
                }
                j++;
                if (!notShare) break;
            }
            numPeop[i] = j;  // Record the number of people in the room
        }

        // Print the summary table
        int counter = 1;
        double frac = 0.0;
        double[] freqList = new double[trials];

        while (frac < 0.5) {

            // Reset variables
            int freq = 0;
            double sumFreq = 0;

            for (int i = 0; i < trials; i++) {
                if (numPeop[i] == counter) freq++;
            }
            freqList[counter - 1] = freq;
            for (int i = 0; i < trials; i++) {
                sumFreq += freqList[i];
            }
            frac = sumFreq / trials;
            System.out.println(counter + "\t" + freq + "\t" + frac);
            counter++;
        }
    }
}
