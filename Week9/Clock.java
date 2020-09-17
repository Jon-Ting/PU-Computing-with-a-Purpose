/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {

    private static final int HR_PER_DAY = 24;
    private static final int MIN_PER_HR = 60;
    private int hour;
    private int min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HR_PER_DAY || m < 0 || m >= MIN_PER_HR)
            throw new IllegalArgumentException("integer out of bound");
        hour = h;
        min = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.matches("\\d{2}:\\d{2}")) throw new IllegalArgumentException("format not HH:MM!");
        int h = Integer.parseInt(s.split(":")[0]);
        int m = Integer.parseInt(s.split(":")[1]);
        if (h < 0 || h >= HR_PER_DAY || m < 0 || m >= MIN_PER_HR)
            throw new IllegalArgumentException();
        hour = h;
        min = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String timeStr = String.format("%02d:%02d", hour, min);
        return timeStr;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        else if (hour == that.hour) return (min < that.min);
        else return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (min != MIN_PER_HR - 1) min += 1;
        else {  // If it is the last minute
            if (hour != HR_PER_DAY - 1) hour += 1;  // But not the last hour
            else hour = 0;
            min = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("delta is negative!");
        int numHr = delta / MIN_PER_HR;
        min += delta - numHr * MIN_PER_HR;  // delta limited to < 60
        if (min >= MIN_PER_HR) {
            min -= MIN_PER_HR;
            hour += 1;
        }
        if (numHr > HR_PER_DAY) numHr = (numHr % HR_PER_DAY);
        hour += numHr;
        if (hour >= HR_PER_DAY) hour -= HR_PER_DAY;
    }

    // Test client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String time = args[2];
        int tocTime = Integer.parseInt(args[3]);
        Clock time1 = new Clock(h, m);
        Clock time2 = new Clock(time);
        StdOut.println(time1);
        StdOut.println(time2);
        StdOut.println(time1.isEarlierThan(time2));
        time1.tic();
        StdOut.println(time1);
        time2.toc(tocTime);
        StdOut.println(time2);
    }
}
