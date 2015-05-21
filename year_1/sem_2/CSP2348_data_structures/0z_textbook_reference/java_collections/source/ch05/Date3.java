public class Date3 {

    // Each Date value is a past, present, or future date.

    // This date is represented by a day-in-epoch number de
    // where 0 is 1 Jan 2000.
    private int de;


    public Date3 (int y, int m, int d) {
    // Construct a date with year y, month m, and day-in-month de.
    // Throw an exception if they constitute an improper date.
        if (m < 1 || m > 12 ||
                d < 1 || d > length(m, y))
            throw new IllegalArgumentException("badly formed date");
        int de = d - 1;
        // Add lengths of months 1 through m-1 in year y ...
        for (int i = 1; i < m; i++)
            de += length(i, y);
        // Add lengths of years 2000 through y-1 ...
        de += 365*(y - 2000);
        // Adjust for leap years ...
        if (y > 2000)
            de += (y - 2001)/4 - (y - 2001)/100 + (y - 2001)/400 + 1;
        else
            de += (y - 2000)/4 - (y - 2000)/100 + (y - 2000)/400;
        this.de = de;
    }


    public boolean equals (Date3 that) {
    // Return true if this date equals that, false otherwise.
        return (this.de == that.de);
    }


    public int compareTo (Date3 that) {
    // Return -1 if this date comes before that,
    // or 0 if this date is equal to that,
    // or +1 if this date come after that.
        return (this.de < that.de ? -1 :
                this.de > that.de ? +1 : 0);
    }


    public String rep () {
    // Return this date's internal representation (TEMPORARY).
        return (de >= 0 ? "M+" + de : "M-" + (-de));
    }


    public String toString () {
    // Return this date's ISO string representation.
        int y = 2000, m = 1, d = this.de + 1;
        int last;
        if (d > 0) {
            while (d > (last = (isLeap(y) ? 366 : 365))) {
                y++;  d -= last;
            }
        } else {
            do {
                y--;  d += (isLeap(y) ? 366 : 365);
            } while (d <= 0);
        }
        while (d > (last = length(m, y))) {
            m++;  d -= last;
        }
        return (y + "-" + m + "-" + d);
    }


    public void advance (int n) {
    // Advance this date by n days (where n >= 0).
        this.de += n;
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
            Date3 thatDay = new Date3(2000, 1, day);
            Date3 lastDay = new Date3(2000, 12, 31);
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
