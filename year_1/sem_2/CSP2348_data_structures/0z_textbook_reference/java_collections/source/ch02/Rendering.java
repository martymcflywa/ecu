public class Rendering {

    private static String render (int i, int r) {
        if (i < 0)
            return "-" + render(-i, r);
        else if (i < r) {
            char d = (char)('0' + i);
            return String.valueOf(d);
        } else {
            char d = (char)('0' + (i%r));
            return render(i/r, r) + String.valueOf(d);
        }
    }

    public static void main (String[] args) {
        for (int b = 2; b <= 10; b++) {
            System.out.print("Base " + b);
            for (int k = 0; k < args.length; k++) {
                int i = Integer.parseInt(args[k]);
                System.out.print("   " + render(i, b));
            }
            System.out.println();
        }
    }

}
