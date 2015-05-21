public class OBHTTest {
    
    public static void main (String[] args) {
        OBHT table1 = new OBHT(26);
        table1.insert(new ChemicalElement("H"),  new Integer(1));
        table1.insert(new ChemicalElement("He"), new Integer(2));
        table1.insert(new ChemicalElement("Li"), new Integer(3));
        table1.insert(new ChemicalElement("Be"), new Integer(4));
        table1.insert(new ChemicalElement("Na"), new Integer(11));
        table1.insert(new ChemicalElement("Mg"), new Integer(12));
        table1.insert(new ChemicalElement("K"),  new Integer(19));
        table1.insert(new ChemicalElement("Ca"), new Integer(20));
        table1.insert(new ChemicalElement("Rb"), new Integer(37));
        table1.insert(new ChemicalElement("Sr"), new Integer(38));
        table1.insert(new ChemicalElement("Cs"), new Integer(55));
        table1.insert(new ChemicalElement("Ba"), new Integer(56));

        System.out.println ("Initial table.");
        System.out.println(table1);
        
        OBHT table2 = (OBHT) table1.clone();
        
        table1.insert(new ChemicalElement("Fr"), new Integer(87));
        table1.insert(new ChemicalElement("Ra"), new Integer(88));
        table1.insert(new ChemicalElement("B"),  new Integer(5));

        System.out.println ("Table after inserting Fr, Ra and B.");
        System.out.println(table1);
        
        table2.delete(new ChemicalElement("Mg"));
        table2.delete(new ChemicalElement("Ca"));
        table2.delete(new ChemicalElement("Ba"));
        
        System.out.println ("Initial table after deleting Mg, Ca and Ba.");
        System.out.println(table2);

    }
}        