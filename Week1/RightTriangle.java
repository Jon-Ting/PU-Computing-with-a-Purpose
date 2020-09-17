/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean isPositive = (a > 0) && (b > 0) && (c > 0);
        boolean sqRight1 = (a * a) == (c * c) + (b * b);
        boolean sqRight2 = (b * b) == (a * a) + (c * c);
        boolean sqRight3 = (c * c) == (a * a) + (b * b);
        boolean isRight = isPositive && (sqRight1 || sqRight2 || sqRight3);
        System.out.println(isRight);
    }
}
