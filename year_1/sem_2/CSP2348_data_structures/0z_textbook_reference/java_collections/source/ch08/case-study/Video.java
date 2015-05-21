import java.util.Iterator;
import javax.swing.ListModel;

import WattBrown.LinkedList;
import WattBrown.List;

public class Video {

    private LinkedList contents;    // list of segments on tape
    private String title;		    // description of tape
    private int length;			    // length in seconds

    public Video (String title, int length) {
    	this.title = title;
    	this.length = length;
    	this.contents = new LinkedList();
    	this.contents.add(new Segment(length));
    }

    public String toString () {
    	String tmp = title + " (" + length + " minutes)\n";
    	Iterator iter = contents.iterator();
    	while (iter.hasNext())
    	    tmp += ((Segment) iter.next()) + "\n";
    	return tmp;
    }

    public String getTitle () {
    	return title;
    }

    public ListModel getListModel () {
    	return (ListModel) new LinkedListModel(this.contents);
    }

    public List getContents () {
	    return (List) this.contents;
    }

    public int getContentsSize () {
    	return this.contents.size();
    }

    public int add (VideoProgram prog) {
    // Add a new program to this video. The program is placed in a new
    // recorded segment, either before or replacing the first blank segment of
    // sufficient length. Return the index of the new segment or -1 if there is
    // insufficient blank space on the videotape.
    	boolean gapFound = false;
    	Segment seg = null;
    	Segment newSeg = new Segment(prog);
    	int i;
    	int len = newSeg.getLength();
    	for (i = 0; i < contents.size(); i++) {
    		seg = (Segment) contents.get(i);
    		if (seg.isBlank() && seg.getLength() >= len) {
    			gapFound = true;
    			break;
    		}
    	}
    	if (gapFound) {
    		int remainder = seg.getLength() - len;
    		if (remainder == 0)
    			contents.set(i, newSeg);
    		else { // remainder > 0
    			contents.add(i, newSeg);
    			seg.setLength(remainder);
    		}
    		return i;
    	} else
    		return -1;
    }

    public void erase (int i) {
    // Removes the program at the given index from the tape.
    // Consecutive blank entries are combined into a single blank entry
    // using mergeBlanks().
    	Segment seg = (Segment) contents.get(i);
    	if (! seg.isBlank()) {
    	    Segment newSeg = new Segment(seg.getLength());
    	    contents.set(i, newSeg);
    	}
    	coalesceBlanks();
    }

    public void coalesceBlanks () {
    // Combines consecutive blank entries into a single blank entry.
    	Iterator iter = contents.iterator();
    	Segment prev = null;

    	while (iter.hasNext()) {
	        Segment curr = (Segment) iter.next();
	        if (prev != null && prev.isBlank() && curr.isBlank()) {
	    	prev.setLength(prev.getLength() + curr.getLength());
	    	iter.remove();
	    } else
	    	prev = curr;
	    }
    }

    public static void main (String[] args) {
    	Video v = new Video("Tape XXX", 180);
    	System.out.print(v);

    	v.add(new VideoProgram("The Simpsons", "BBC2", 25, false));
    	System.out.print(v);

    	v.add(new VideoProgram("Frazier", "C4", 30, true));
    	System.out.print(v);

    	v.erase(0);
    	System.out.print(v);

    	v.erase(1);
    	System.out.print(v);
    }

}
