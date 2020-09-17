/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        Picture filtPic = new Picture(picture.width(), picture.height());
        double[][] kernel = {
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 },
                { 2.0 / 16, 4.0 / 16, 2.0 / 16 },
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 }
        };

        // Loop through each pixel
        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {

                // Loop through each element of the kernel
                double kernelSumR = 0.0;
                double kernelSumG = 0.0;
                double kernelSumB = 0.0;
                for (int i = -1; i < kernel.length - 1; i++) {
                    for (int j = -1; j < kernel.length - 1; j++) {

                        // Get the coordinate of pixel to be multiplied with kernel
                        int x = row + i;
                        int y = col + j;
                        if (row + i < 0) x += picture.height();
                        else if (row + i >= picture.height()) x -= picture.height();
                        if (col + j < 0) y += picture.width();
                        else if (col + j >= picture.width()) y -= picture.width();

                        // Apply the kernel filter
                        double filter = kernel[i + 1][j + 1];
                        kernelSumR += picture.get(y, x).getRed() * filter;
                        kernelSumG += picture.get(y, x).getGreen() * filter;
                        kernelSumB += picture.get(y, x).getBlue() * filter;
                    }
                }
                kernelSumR = Math.min(255, Math.max(0, Math.round(kernelSumR)));
                kernelSumG = Math.min(255, Math.max(0, Math.round(kernelSumG)));
                kernelSumB = Math.min(255, Math.max(0, Math.round(kernelSumB)));
                // StdOut.println("New RGB: " + kernelSumR + " " + kernelSumG + " " + kernelSumB);
                Color newC = new Color((int) kernelSumR, (int) kernelSumG, (int) kernelSumB);
                filtPic.set(col, row, newC);
            }
        }
        return filtPic;
    }


    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        Picture filtPic = new Picture(picture.width(), picture.height());
        int[][] kernel = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                double kernelSumR = 0.0;
                double kernelSumG = 0.0;
                double kernelSumB = 0.0;
                for (int i = -1; i < kernel.length - 1; i++) {
                    for (int j = -1; j < kernel.length - 1; j++) {
                        int x = row + i;
                        int y = col + j;
                        if (row + i < 0) x += picture.height();
                        else if (row + i >= picture.height()) x -= picture.height();
                        if (col + j < 0) y += picture.width();
                        else if (col + j >= picture.width()) y -= picture.width();
                        int filter = kernel[i + 1][j + 1];
                        kernelSumR += picture.get(y, x).getRed() * filter;
                        kernelSumG += picture.get(y, x).getGreen() * filter;
                        kernelSumB += picture.get(y, x).getBlue() * filter;
                    }
                }
                kernelSumR = Math.min(255, Math.max(0, kernelSumR));
                kernelSumG = Math.min(255, Math.max(0, kernelSumG));
                kernelSumB = Math.min(255, Math.max(0, kernelSumB));
                // StdOut.println("New RGB: " + kernelSumR + " " + kernelSumG + " " + kernelSumB);
                Color newC = new Color((int) kernelSumR, (int) kernelSumG, (int) kernelSumB);
                filtPic.set(col, row, newC);
            }
        }
        return filtPic;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        Picture filtPic = new Picture(picture.width(), picture.height());
        double[][] kernel = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                double kernelSumR = 0.0;
                double kernelSumG = 0.0;
                double kernelSumB = 0.0;
                for (int i = -1; i < kernel.length - 1; i++) {
                    for (int j = -1; j < kernel.length - 1; j++) {
                        int x = row + i;
                        int y = col + j;
                        if (row + i < 0) x += picture.height();
                        else if (row + i >= picture.height()) x -= picture.height();
                        if (col + j < 0) y += picture.width();
                        else if (col + j >= picture.width()) y -= picture.width();
                        double filter = kernel[i + 1][j + 1];
                        kernelSumR += picture.get(y, x).getRed() * filter;
                        kernelSumG += picture.get(y, x).getGreen() * filter;
                        kernelSumB += picture.get(y, x).getBlue() * filter;
                    }
                }
                kernelSumR = Math.min(255, Math.max(0, kernelSumR));
                kernelSumG = Math.min(255, Math.max(0, kernelSumG));
                kernelSumB = Math.min(255, Math.max(0, kernelSumB));
                // StdOut.println("New RGB: " + kernelSumR + " " + kernelSumG + " " + kernelSumB); // Debug
                Color newC = new Color((int) kernelSumR, (int) kernelSumG, (int) kernelSumB);
                filtPic.set(col, row, newC);
            }
        }
        return filtPic;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        Picture filtPic = new Picture(picture.width(), picture.height());
        int[][] kernel = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                double kernelSumR = 0.0;
                double kernelSumG = 0.0;
                double kernelSumB = 0.0;
                for (int i = -1; i < kernel.length - 1; i++) {
                    for (int j = -1; j < kernel.length - 1; j++) {
                        int x = row + i;
                        int y = col + j;
                        if (row + i < 0) x += picture.height();
                        else if (row + i >= picture.height()) x -= picture.height();
                        if (col + j < 0) y += picture.width();
                        else if (col + j >= picture.width()) y -= picture.width();
                        int filter = kernel[i + 1][j + 1];
                        kernelSumR += picture.get(y, x).getRed() * filter;
                        kernelSumG += picture.get(y, x).getGreen() * filter;
                        kernelSumB += picture.get(y, x).getBlue() * filter;
                    }
                }
                kernelSumR = Math.min(255, Math.max(0, kernelSumR));
                kernelSumG = Math.min(255, Math.max(0, kernelSumG));
                kernelSumB = Math.min(255, Math.max(0, kernelSumB));
                // StdOut.println("New RGB: " + kernelSumR + " " + kernelSumG + " " + kernelSumB); // Debug
                Color newC = new Color((int) kernelSumR, (int) kernelSumG, (int) kernelSumB);
                filtPic.set(col, row, newC);
            }
        }
        return filtPic;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        Picture filtPic = new Picture(picture.width(), picture.height());

        // Make the kernel
        int limitDim = Math.min(picture.width(), picture.height());
        double[][] kernel;
        if (limitDim < 9) kernel = new double[limitDim][limitDim];
        else kernel = new double[9][9];
        for (int i = 0; i < kernel.length; i++) kernel[i][i] = 1.0 / kernel.length;

        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                double kernelSumR = 0.0;
                double kernelSumG = 0.0;
                double kernelSumB = 0.0;
                for (int i = -kernel.length / 2; i < kernel.length - (kernel.length / 2); i++) {
                    for (int j = -kernel.length / 2; j < kernel.length - (kernel.length / 2); j++) {
                        int x = row + i;
                        int y = col + j;
                        if (row + i < 0) x += picture.height();
                        else if (row + i >= picture.height()) x -= picture.height();
                        if (col + j < 0) y += picture.width();
                        else if (col + j >= picture.width()) y -= picture.width();
                        double filter = kernel[i + kernel.length / 2][j + kernel.length / 2];
                        kernelSumR += picture.get(y, x).getRed() * filter;
                        kernelSumG += picture.get(y, x).getGreen() * filter;
                        kernelSumB += picture.get(y, x).getBlue() * filter;
                    }
                }
                kernelSumR = Math.min(255, Math.max(0, Math.round(kernelSumR)));
                kernelSumG = Math.min(255, Math.max(0, Math.round(kernelSumG)));
                kernelSumB = Math.min(255, Math.max(0, Math.round(kernelSumB)));
                // StdOut.println("New RGB: " + kernelSumR + " " + kernelSumG + " " + kernelSumB); // Debug
                Color newC = new Color((int) kernelSumR, (int) kernelSumG, (int) kernelSumB);
                filtPic.set(col, row, newC);
            }
        }
        return filtPic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        // Picture pic = new Picture("baboon.png");  // Debug
        pic.show();
        gaussian(pic).show();
        sharpen(pic).show();
        laplacian(pic).show();
        emboss(pic).show();
        motionBlur(pic).show();
    }
}
