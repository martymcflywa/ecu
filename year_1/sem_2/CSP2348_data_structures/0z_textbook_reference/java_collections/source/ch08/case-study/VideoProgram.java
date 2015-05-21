public class VideoProgram {

    private String title;
    private String channel;
    private int duration;
    private boolean isLongPlay;

    private static String spaces = "                              "; // 30 spaces

    public VideoProgram (String title, String channel, int duration,
            	    boolean isLongPlay) {
    	this.title = title;
    	this.channel = channel;
    	this.duration = duration;
    	this.isLongPlay = isLongPlay;
    }

    public String toString () {
	    String temp = spaces + (duration / 60);
    	return temp.substring(temp.length() - 5) + " " +
	           (channel + spaces).substring(0, 5) + " " +
    	       (title + spaces).substring(0, 30) + " " +
    	       (isLongPlay ? "LP" : "SP");
    }

    public boolean isLongPlay () {
    	return isLongPlay;
    }

    public String getTitle () {
    	return title;
    }

    public String getChannel () {
    	return channel;
    }

    public int getDuration () {
    	return duration;
    }

}
