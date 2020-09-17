/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int maxNum = 0;
        int currNum = 0;
        int codonCount = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            if (codonCount != 0) {
                codonCount -= 1;
                continue;
            }
            String codon = dna.substring(i, i + 3);
            if (codon.equals("CAG")) {  // When CAG codon is found
                currNum++;
                codonCount = 2;
                if (currNum > maxNum) maxNum = currNum;
            }
            else currNum = 0; // Otherwise reset variable
        }
        return maxNum;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String newS = s;
        newS = newS.replace(" ", "").replace("\t", "").replace("\n", "");
        return newS;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats > 9 && maxRepeats < 36) return "normal";
        else if (maxRepeats > 35 && maxRepeats < 40) return "high risk";
        else if (maxRepeats > 39 && maxRepeats < 181) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In fileName = new In(args[0]);
        String seq = fileName.readAll();
        // String seq = "TTCAGCAGCAGCAG";  // Debug
        // StdOut.println(seq);  // Debug
        seq = removeWhitespace(seq);
        int maxNum = maxRepeats(seq);
        StdOut.println("max repeats = " + maxNum);
        StdOut.println(diagnose(maxNum));
    }
}
