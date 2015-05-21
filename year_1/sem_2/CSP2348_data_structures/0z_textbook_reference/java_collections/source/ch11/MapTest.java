import WattBrown.*;

public class MapTest {

    public static void main (String[] args) {

	Map m1 = new LinkedMap();
	System.out.println(m1);
	System.out.println(m1.keySet());

	m1.put("CA", "English");
	m1.put("MX", "Spanish");
	m1.put("US", "English");
	System.out.println(m1);
	System.out.println(m1.keySet());

        m1.put("BM", "English");
	m1.put("CU", "Spanish");
	System.out.println(m1);
	System.out.println(m1.keySet());

	m1.remove("BM");
	m1.remove("GB");
	System.out.println(m1);
	System.out.println(m1.keySet());

    }
}
