public class Date2 {


    // Each Date value is a past, present, or future date.

    // This date is represented by a year number y, and a day-in-year
    // number d (1 <= d <= year length <= 366).
    private int y;
    private int d;


    public Date2 (int y, int m, int d) {
    // Construct a date with year y, month m, and day-in-month d.
    // Throw an exception if they constitute an improper date.
        if (m < 1 || m > 12 ||
                d < 1 || d > length(m, y))
            throw new IllegalArgumentException("badly formed date");
        for (int i = 1; i < m; i++)
            d += length(i, y);
        this.y = y;  this.d = d;
    }


    public boolean equals (Date2 that) {
    // Return true if this date equal to that, or false otherwise.
        return (this.y == that.y && this.d == that.d);
    }


    public int compareTo (Date2 that) {
    // Return -1 if this date comes before that,
    // or 0 if this date is equal to that,
    // or +1 if this date come after that.
        return (this.y < that.y ? -1 :
                this.y > that.y ? +1 :
                this.d < that.d ? -1 :
                this.d > that.d ? +1 : 0);
    }


    public String toString () {
    // Return this date's ISO string representation.
        int y = this.y, m = 1, d = this.d;
        int last;
        while (d > (last = length(m, y))) {
            d -= last;  m++;
        }
        return (y + "-" + m + "-" + d);
    }


    public void advance (int n) {
    // Advance this date by n days (where n >= 0).
        int y = this.y, d = this.d + n;
        int last;
        while (d > (last = (isLeap(y) ? 366 : 365))) {
            d -= last;  y++;
        }
        this.y = y;  this.d = d;
    }


    private static int length (int m, int y) {
    // Return the number of days in month m in year y.
        switch (m) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeap(y) ? 29 : 28);
            default:
                return -1;
        }
    }


    private static boolean isLeap (int y) {
    // Return true if and only if y is a leapyear.
        return (y%4 == 0 && (y%100 != 0 || y%400 == 0));
    }


    public static void main (String[] args) {
    // Given a day-name as an argument, print out all the dates in year 2000
    // falling on the named day.
        String dayName = args[0];
        int day = dayName.equals("Saturday")  ? 1 :
                  dayName.equals("Sunday")    ? 2 :
                  dayName.equals("Monday")    ? 3 :
                  dayName.equals("Tuesday")   ? 4 :
                  dayName.equals("Wednesday") ? 5 :
                  dayName.equals("Thursday")  ? 6 :
                  dayName.equals("Friday")    ? 7 : 0;
        try {
            Date2 thatDay = new Date2(2000, 1, day);
            Date2 lastDay = new Date2(2000, 12, 31);
            System.out.println(dayName + "s in 2000:");
            do {
                System.out.println(thatDay);
                thatDay.advance(7);
            } while (thatDay.compareTo(lastDay) <= 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
