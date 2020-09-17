/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amA = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amA[i] = a[i] * alpha;
        }
        return amA;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] revA = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            revA[i] = a[a.length - i - 1];
        }
        return revA;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] merAB = new double[a.length + b.length];
        for (int i = 0; i < a.length + b.length; i++) {
            if (i < a.length) merAB[i] = a[i];
            else merAB[i] = b[i - a.length];
        }
        return merAB;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        // Pad the shorter array
        if (a.length > b.length) b = Arrays.copyOf(b, a.length);
        else if (b.length > a.length) a = Arrays.copyOf(a, b.length);

        double[] sumAB = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            sumAB[i] = a[i] + b[i];
        }
        return sumAB;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] resampA = new double[(int) (a.length / alpha)];
        for (int i = 0; i < resampA.length; i++) {
            resampA[i] = a[(int) (i * alpha)];
        }
        return resampA;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        String[] wavFiles = { "buzzer.wav", "chimes.wav", "harp.wav", "piano.wav", "singer.wav" };
        for (int i = 0; i < wavFiles.length; i++) {
            double[] soundWav = StdAudio.read(wavFiles[i]);
            double ampAlpha = 2.0;
            double speedAlpha = 2.0;

            // StdOut.println(".wav file: " + wavFiles[i]);

            // StdOut.println("Amplified, alpha: " + ampAlpha);
            StdAudio.play(amplify(soundWav, ampAlpha));
            // StdOut.println("Reversed");
            StdAudio.play(reverse(soundWav));
            // StdOut.println("Merged " + wavFiles[i] + " with " + wavFiles[i]);
            StdAudio.play(merge(soundWav, soundWav));
            // StdOut.println("Mixed" + wavFiles[i] + " with " + wavFiles[i]);
            StdAudio.play(mix(soundWav, soundWav));
            // StdOut.println("Changed speed, alpha: " + speedAlpha);
            StdAudio.play(changeSpeed(soundWav, speedAlpha));

            // StdOut.println();
        }
    }
}
