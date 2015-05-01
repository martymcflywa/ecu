package com.martinponce.csp2348.a2.linkedlistprogramming.alternative;

/**
 * Main executable class to test alternative UnitList.
 *
 * @author jitian XIAO and Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150427
 */
public class Main {

    private final int[] STUDENT_DATA = {
            1111, 17, 22, 30,
            1112, 10, 6,  50,
            1114, 14, 21, 30,
            1116, 8,  16, 35,
            1122, 11, 19, 40,
            1145, 9,  16, 20,
            1189, 20, 30, 50
    };

    private UnitList theUnitList;

    public Main() {

        // create new list
        theUnitList = new UnitList();

        // fill new list with STUDENT_DATA
        for(int i = 0; i < STUDENT_DATA.length; i += 4) {
            theUnitList.insertLast(STUDENT_DATA[i], STUDENT_DATA[i + 1], STUDENT_DATA[i + 2], STUDENT_DATA[i + 3]);
        }

        // initial print
        theUnitList.printUnitResult(theUnitList);
        // get highest mark
        theUnitList.getHighestMark();

        // insert another node
        theUnitList.insertLast(1225, 17, 20, 20);
        theUnitList.printUnitResult(theUnitList);

        // delete first node
        theUnitList.deleteUnitResult(1111);
        theUnitList.printUnitResult(theUnitList);

        // expecting error messages here
        theUnitList.deleteUnitResult(1111);
        theUnitList.deleteUnitResult(997);
        theUnitList.deleteUnitResult(10075);

        // delete another node down the list
        theUnitList.deleteUnitResult(1116);
        theUnitList.deleteUnitResult(1145);
        theUnitList.printUnitResult(theUnitList);

        // test reverse printing
        theUnitList.printUnitResultReverse();

    }

    public static void main(String[] args) {
        Main run = new Main();
    }
}
