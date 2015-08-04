package csg2341.skynet.ponce.mortgage;

/**
 * Example test driver for the Mortgage expert system.
 * CSG2341 Intelligent Systems, Workshop 2
 *
 * @author (phi)
 * @version (2006/2)
 */

import au.edu.ecu.is.fuzzy.*;

import javax.swing.*;
import java.awt.GridLayout;

public class TestMortgage extends JFrame {
    // Creates a display showing the input variables and allowing the user to
    // set their crisp values
    public TestMortgage() throws FuzzyException {
        super("Test driver for the mortgage application");

        // inputs on left, output on right
        setLayout(new GridLayout(1, 2));

        // create the Expert System
        MortgageES es = new MortgageES();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1));

        // add a panels to display each input variable
        inputPanel.add(es.getMarketValuePanel());
        inputPanel.add(es.getLocationPanel());
        inputPanel.add(es.getAssetPanel());
        inputPanel.add(es.getIncomePanel());
        inputPanel.add(es.getInterestPanel());

        add(inputPanel);

        // and the output variable
        add(es.getCreditPanel());

        // set initial crisp values for input variables
        es.setMarketValue(55);
        es.setLocation(5);
        es.setAsset(120);
        es.setIncome(67);
        es.setInterest(5.5);

        // now fire the rules
        es.update();

        // this allows the user to close the application by closing the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // arrange contents and throw up the window
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new TestMortgage();
    }
}
