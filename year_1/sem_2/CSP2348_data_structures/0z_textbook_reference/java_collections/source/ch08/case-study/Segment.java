public class Segment {

    private int length;
    private VideoProgram program;

    private static String spaces;	// string of spaces for formatting

    private Segment () {
    	if (spaces == null) {
    	    spaces = "";
    	    for (int i = 0; i < 80; i++)
    		spaces += " ";
    	}
    }

    public Segment (int length) {
    	this();
    	this.length = length;
    	this.program = null;
    }

    public Segment (VideoProgram program) {
        this();
        int duration = program.getDuration();
        this.length = program.isLongPlay() ? (duration+1)/2 : duration;
        this.program = program;
    }

    public int getLength () {
    	return length;
    }


    public VideoProgram getProgram () {
        return program;
    }

    public boolean isBlank () {
        return (program == null);
    }

    public void setLength (int length) {
	    if (this.program == null)
	        this.length = length;
    }

    public String toString () {
    	if (program != null)
    	    return program.toString();
        else {
            String temp = spaces + (length / 60);
  	        return temp.substring(temp.length() - 5) + " BLANK";
  	    }
    }
}
