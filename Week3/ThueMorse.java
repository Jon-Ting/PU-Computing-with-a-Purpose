/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {

        // Set variables
        int n = Integer.parseInt(args[0]);
        int[] tmSeq = new int[n];
        int[] existSeq = { 0 };
        int iterNum = 0;
        int remainder = n;
        boolean excLength = false;

        // Calculate number of iterations needed
        while (remainder > 0) {
            remainder = n - (int) Math.pow(2, iterNum);
            iterNum++;
        }

        // Generate Thue-Morse sequence
        for (int i = 0; i < iterNum - 1; i++) {
            for (int j = 0; j < existSeq.length; j++) {
                int comp;
                if (existSeq[j] == 0) comp = 1;
                else comp = 0;
                if (existSeq.length + j == tmSeq.length) {
                    excLength = true;
                    break;
                }
                tmSeq[existSeq.length + j] = comp;
            }
            if (excLength) break;
            existSeq = new int[existSeq.length * 2];
            System.arraycopy(tmSeq, 0, existSeq, 0, existSeq.length);
        }
        /* for (int i = 0; i < tmSeq.length; i++) {
            System.out.println(tmSeq[i]);
        }  */  // Debug

        // Compute the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmSeq[i] == tmSeq[j]) System.out.print("+");
                else System.out.print("-");
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
