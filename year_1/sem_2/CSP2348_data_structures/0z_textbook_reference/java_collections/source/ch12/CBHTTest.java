public class CBHTTest {
    
    public static void main (String[] args) {
        CBHT table1 = new CBHT(26);
        table1.insert(new ChemicalElement("F"),  new Integer(9));
        table1.insert(new ChemicalElement("Ne"), new Integer(10));
        table1.insert(new ChemicalElement("Cl"), new Integer(17));
        table1.insert(new ChemicalElement("Ar"), new Integer(18));
        table1.insert(new ChemicalElement("Br"), new Integer(35));
        table1.insert(new ChemicalElement("Kr"), new Integer(36));
        table1.insert(new ChemicalElement("I"),  new Integer(53));
        table1.insert(new ChemicalElement("Xe"), new Integer(54));

        System.out.println ("Table from Figure 12.20A(a)");
        System.out.println(table1);

        CBHT table2 = new CBHT(26);
        table2.insert(new ChemicalElement("H"),  new Integer(1));
        table2.insert(new ChemicalElement("He"), new Integer(2));
        table2.insert(new ChemicalElement("Li"), new Integer(3));
        table2.insert(new ChemicalElement("Be"), new Integer(4));
        table2.insert(new ChemicalElement("Na"), new Integer(11));
        table2.insert(new ChemicalElement("Mg"), new Integer(12));
        table2.insert(new ChemicalElement("K"),  new Integer(19));
        table2.insert(new ChemicalElement("Ca"), new Integer(20));
        table2.insert(new ChemicalElement("Rb"), new Integer(37));
        table2.insert(new ChemicalElement("Sr"), new Integer(38));
        table2.insert(new ChemicalElement("Cs"), new Integer(55));
        table2.insert(new ChemicalElement("Ba"), new Integer(56));

        System.out.println ("Table from Figure 12.20A(b)");
        System.out.println(table2);
    }
}        