import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;

class Part {

    private String partId, description;
    private int leadTime;
    private boolean isProduct;
    private int[] required, available, delivered, ordered;

    public final static int MAX_WEEKS = 10;

    private Part () {
        this.partId = "";
        this.leadTime = 0;
        this.description = "";
        this.required = null;
        this.available = null;
        this.delivered = null;
        this.ordered = null;
        this.isProduct = false;
    }

    public Part (String partId, String description, int leadTime,
            int available) {
        this.partId = partId;
        this.leadTime = leadTime;
        this.description = description;
        this.isProduct = false;
        this.required = new int[MAX_WEEKS];
        this.available = new int[MAX_WEEKS];
        this.delivered = new int[MAX_WEEKS];
        this.ordered = new int[MAX_WEEKS];
        this.available[0] = available;
    }

    public static Part readPart (BufferedReader input)
	    throws IOException {

	String line = input.readLine();
	if (line == null)  return null;

	String partId = line.substring(0, 2).trim();
	int available = Integer.parseInt(line.substring(3, 6).trim());
	int leadTime = Integer.parseInt(line.substring(7, 8));
	String description = line.substring(9);

	return new Part(partId, description, leadTime, available);
    }

    public String toString () {
	return partId + " " + available[0] + " " +
	        leadTime + " " + description + "\n";
    }

    public String getPartId () {
	return this.partId;
    }

    public boolean isProduct () {
    	return this.isProduct;
    }

    public void setRequirements (int weekNum, int qty) {
	this.required[weekNum] = qty;
    }

    public void updateRequirements (Part other, int qty) {
        for (int i = 0; i < MAX_WEEKS; i++)
	    this.required[i] +=  other.ordered[i] * qty;
    }

    public void markAsProduct () {
    	this.isProduct = true;
    }

    public void calculateQuantities () {
	for (int i = 1; i < MAX_WEEKS; i++) {
	    available[i] = Math.max(0, available[i-1] - required[i-1]);
	    delivered[i] = Math.max(0, required[i] - available[i]);
	    if (delivered[i] > 0) {
		int orderWeek = Math.max(0, i - leadTime);
		ordered[orderWeek] += delivered[i];
	    }
	}
    }

    private static String separator;

    static {
    // Initialize separator to a line of '-'s.
	separator = "";
	for (int i = 0; i < 78; i++)  separator += "-";
	separator += "\n";
    }


    public String generateReport () {
	DecimalFormat df = new DecimalFormat("###0");

	String title =  "| Part: " + this.partId + " " + this.description;
	for (int i = title.length(); i < 77; i++)    title += " ";
	title = title.substring(0, 77) + "|\n";
	title += "| Week number           | ";

	String line1 = "| Required quantity     | ";
	String line2 = "| Available quantity    | ";
	String line3 = "| Delivered quantity    | ";
	String line4 = "| Ordered quantity      | ";

	for (int i = 0; i < MAX_WEEKS; i++) {
	    String t0, t1, t2, t3, t4;
	    t0 = "     " + df.format(i);
	    if (required[i] != 0)
		t1 = "     " + df.format(required[i]);
	    else
		t1 = "     ";
	    if (available[i] != 0)
	        t2 = "     " + df.format(available[i]);
	    else
		t2 = "     ";
	    if (delivered[i] != 0)
	        t3 = "     " + df.format(delivered[i]);
	    else
		t3 = "     ";
	    if (ordered[i] != 0)
	        t4 = "     " + df.format(ordered[i]);
	    else
		t4 = "     ";

	    title += t0.substring(t0.length() - 5);
	    line1 += t1.substring(t1.length() - 5);
	    line2 += t2.substring(t2.length() - 5);
	    line3 += t3.substring(t3.length() - 5);
	    line4 += t4.substring(t4.length() - 5);
        }
        return separator + title + " |\n" + separator +
		line1 + " |\n" + line2 + " |\n" + line3 + " |\n" +
		line4 + " |\n" + separator;
    }
}
