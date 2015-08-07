package net.sky.csg2341.ponce.ws02;

import au.edu.ecu.is.fuzzy.*;

/**
 * Partial solution for the Mortgage expert system.
 * CSG2341 Intelligent Systems, Workshop 2
 * <p/>
 * Parts to be completed are indicated by comments in the code.
 * <p/>
 * Note - the program will compile and run without changes, but will not give sensible results.
 *
 * @author (phi) & Martin Ponce 10371381
 * @version (2015/2) 20150807
 */
public class MortgageES {
    // the fuzzy variables needed for this system
    private FuzzyVariable marketValue;
    private FuzzyVariable location;
    private FuzzyVariable house;
    private FuzzyVariable asset;
    private FuzzyVariable income;
    private FuzzyVariable applicant;
    private FuzzyVariable interest;
    private FuzzyVariable credit;
    // and the rules we build with them
    private MamdaniRuleSet ruleSet;

    // For testing just calls the constructor
    public static void main(String[] args) throws FuzzyException {
        new MortgageES();
    }

    /**
     * Constructor for a mortgage expert system instance
     *
     * @throws FuzzyException - shouldn't though
     */
    public MortgageES() throws FuzzyException {
        // create a new Mamdani-style ruleset
        ruleSet = new MamdaniRuleSet();

        // construct a fuzzy variable to represent the market value of the property
        marketValue = new FuzzyVariable("market value", "$000's", 0.0, 1000.0, 3);
        // create fuzzy sets to represent the possible linguistic values for market value
        FuzzySet mvVeryHigh = new FuzzySet("very high", 650.0, 850.0, 1000.0, 1000.0);
        FuzzySet mvHigh = new FuzzySet("high", 200.0, 300.0, 650.0, 850.0);
        FuzzySet mvMedium = new FuzzySet("medium", 50.0, 100.0, 200.0, 250.0);
        FuzzySet mvLow = new FuzzySet("low", 0.0, 0.0, 75.0, 100.0);
        // and add them as allowed linguistic values for this variable
        marketValue.add(mvVeryHigh);
        marketValue.add(mvHigh);
        marketValue.add(mvMedium);
        marketValue.add(mvLow);


        // *** Step 2f: TO BE DONE *** //
        // *** uncomment the line below *** //
        System.out.println(marketValue.checkGaps());
        // for illustrative/diagnostic purposes, display the variable graphically
        // (should be removed from the final version)
        //marketValue.display();

        /////////////////// now do likewise for the other fuzzy variables ///////////////////

        // *** Step 2c: TO BE COMPLETED *** //
        // *** add the missing parameters and uncomment the code *** //
        // *** also fix the "set" methods below *** //

        location = new FuzzyVariable("location", "rating", 0.0, 10.0, 1);
        FuzzySet locBad = new FuzzySet("bad", 0.0, 0.0, 1.5, 4.0);
        FuzzySet locFair = new FuzzySet("fair", 2.5, 5.0, 6.0, 8.5);
        FuzzySet locExcellent = new FuzzySet("excellent", 6.0, 8.5, 10.0, 10.0);
        location.add(locBad);
        location.add(locFair);
        location.add(locExcellent);

        System.out.println(location.checkGaps());
        //location.display();

        house = new FuzzyVariable("house", "rating", 0.0, 10.0, 1);
        FuzzySet houseVeryLow = new FuzzySet("very low", 0.0, 0.0, 0.0, 3.0);
        FuzzySet houseLow = new FuzzySet("low", 0.0, 3.0, 3.0, 6.0);
        FuzzySet houseMedium = new FuzzySet("medium", 2.0, 5.0, 5.0, 8.0);
        FuzzySet houseHigh = new FuzzySet("high", 4.0, 7.0, 7.0, 10.0);
        FuzzySet houseVeryHigh = new FuzzySet("very high", 7.0, 10.0, 10.0, 10.0);
        house.add(houseVeryLow);
        house.add(houseLow);
        house.add(houseMedium);
        house.add(houseHigh);
        house.add(houseVeryHigh);

        System.out.println(house.checkGaps());
        //house.display();

        asset = new FuzzyVariable("asset", "$000's", 0.0, 1000.0, 3);
        FuzzySet assetLow = new FuzzySet("low", 0.0, 0.0, 0.0, 150.0);
        FuzzySet assetMedium = new FuzzySet("medium", 50.0, 250.0, 450.0, 650.0);
        FuzzySet assetHigh = new FuzzySet("high", 500.0, 700.0, 1000.0, 1000.0);
        asset.add(assetLow);
        asset.add(assetMedium);
        asset.add(assetHigh);

        System.out.println(asset.checkGaps());
        //asset.display();

        income = new FuzzyVariable("income", "$000's", 0.0, 100.0, 3);
        FuzzySet incomeLow = new FuzzySet("low", 0.0, 0.0, 10.0, 25.0);
        FuzzySet incomeMedium = new FuzzySet("medium", 15.0, 35.0, 35.0, 55.0);
        FuzzySet incomeHigh = new FuzzySet("high", 40.0, 60.0, 60.0, 80.0);
        FuzzySet incomeVeryHigh = new FuzzySet("very high", 60.0, 80.0, 100.0, 100.0);
        income.add(incomeLow);
        income.add(incomeMedium);
        income.add(incomeHigh);
        income.add(incomeVeryHigh);

        System.out.println(income.checkGaps());
        //income.display();

        applicant = new FuzzyVariable("applicant", "rating", 0.0, 10.0, 1);
        FuzzySet applicantLow = new FuzzySet("low", 0.0, 0.0, 2.0, 4.0);
        FuzzySet applicantMedium = new FuzzySet("medium", 2.0, 5.0, 5.0, 8.0);
        FuzzySet applicantHigh = new FuzzySet("high", 6.0, 8.0, 10.0, 10.0);
        applicant.add(applicantLow);
        applicant.add(applicantMedium);
        applicant.add(applicantHigh);

        System.out.println(applicant.checkGaps());
        //applicant.display();

        interest = new FuzzyVariable("interest", "%", 0.0, 10.0, 1);
        FuzzySet interestLow = new FuzzySet("low", 0.0, 0.0, 2.0, 5.0);
        FuzzySet interestMedium = new FuzzySet("medium", 2.0, 4.0, 6.0, 8.0);
        FuzzySet interestHigh = new FuzzySet("high", 6.0, 8.5, 10.0, 10.0);
        interest.add(interestLow);
        interest.add(interestMedium);
        interest.add(interestHigh);

        System.out.println(interest.checkGaps());
        //interest.display();

        credit = new FuzzyVariable("credit", "$000's", 0.0, 500.0, 3);
        FuzzySet creditVeryLow = new FuzzySet("very low", 0.0, 0.0, 0.0, 125.0);
        FuzzySet creditLow = new FuzzySet("low", 0.0, 125.0, 125.0, 250.0);
        FuzzySet creditMedium = new FuzzySet("medium", 125.0, 250.0, 250.0, 375.0);
        FuzzySet creditHigh = new FuzzySet("high", 250.0, 375.0, 375.0, 500.0);
        FuzzySet creditVeryHigh = new FuzzySet("very high", 375.0, 500.0, 500.0, 500.0);
        credit.add(creditVeryLow);
        credit.add(creditLow);
        credit.add(creditMedium);
        credit.add(creditHigh);
        credit.add(creditVeryHigh);

        System.out.println(credit.checkGaps());
        //credit.display();


        ////////// now create and add fuzzy rules //////////////////////////////////////

        //// Home evaluation rules

        // *** Step 2d: TO BE COMPLETED *** //
        // *** uncomment the house rating rules *** //

        //// if (market value is low) then (house is low)
        ruleSet.addRule(marketValue, mvLow, house, houseLow);

        //// if (location is bad) then (house is low)
        ruleSet.addRule(location, locBad, house, houseLow);

        // here we add a matrix of rules about house ratings for all
        // combinations of location and market value
        FuzzySet[] locationSets = {locBad, locFair, locExcellent};
        FuzzySet[] mvSets = {mvLow, mvMedium, mvHigh, mvVeryHigh};
        FuzzySet[][] houseMatrix = {
                {houseVeryLow, houseLow, houseMedium, houseHigh},
                {houseLow, houseMedium, houseHigh, houseVeryHigh},
                {houseMedium, houseHigh, houseVeryHigh, houseVeryHigh}
        };

        ruleSet.addRuleMatrix(
                location, locationSets,
                marketValue, mvSets,
                house, houseMatrix
        );

        //////////// create graphical display showing the fuzzy inference process
        //////////// for house rating

        //// this would be removed in the final version

        //// this creates a matrix-based display
//        ruleSet.displayRuleMatrix(
//                location, locationSets,
//                marketValue, mvSets,
//                house
//        );

        //// the following alternative creates a scrolling list of all rules determining house rating
        (new FuzzyRuleSubsetPanel(ruleSet, house)).display();

        // *** Step 2e: TO BE COMPLETED *** //
        // *** complete uncomment the remaining rules *** //
        // *** and uncomment the "update" and "get" methods below *** //

        //// Applicant evaluation rules

        /**
         * TODO: NOTE TO SELF
         * Using addRuleMatrix()
         * FuzzySet[] antecedent1
         * FuzzySet[] antecedent2 == AND antecedent
         * FuzzySet[][] consequent == product of set1 and set2
         */
        // IF antecedent
        FuzzySet[] assetSets = {assetLow, assetMedium, assetHigh};
        // AND antecedent
        FuzzySet[] incomeSets = {incomeLow, incomeMedium, incomeHigh, incomeVeryHigh};
        // THEN consequent
        FuzzySet[][] applicantMatrix = {
                {applicantLow, applicantLow, applicantMedium, applicantHigh},
                {applicantLow, applicantMedium, applicantHigh, applicantHigh},
                {applicantMedium, applicantMedium, applicantHigh, applicantHigh}
        };

        ruleSet.addRuleMatrix(
                asset, assetSets,
                income, incomeSets,
                applicant, applicantMatrix
        );

        //// Credit rules

        /**
         * TODO: NOTE TO SELF
         * Add singleton rules using addRule(),
         * then do use rule matrix for bulk rules with grouped antecedents.
         */
        //// if (income is low) and (interest is medium) then (credit is very low)
        ruleSet.addRule(income, incomeLow, interest, interestMedium, credit, creditVeryLow);
        //// if (income is low) and (interest is high) then (credit is very low)
        ruleSet.addRule(income, incomeLow, interest, interestHigh, credit, creditVeryLow);
        //// if (income is medium) and (interest is high) then (credit is low)
        ruleSet.addRule(income, incomeMedium, interest, interestHigh, credit, creditLow);
        //// if (applicant is low) then (credit is very low)
        ruleSet.addRule(applicant, applicantLow, credit, creditVeryLow);
        //// if (house is very low) then (credit is very low)
        ruleSet.addRule(house, houseVeryLow, credit, creditVeryLow);

        FuzzySet[] applicantSets = {applicantMedium, applicantHigh};
        FuzzySet[] houseSets = {houseVeryLow, houseLow, houseMedium, houseHigh, houseVeryHigh};
        FuzzySet[][] creditMatrix = {
                {creditLow, creditLow, creditMedium, creditHigh, creditHigh},
                {creditLow, creditMedium, creditHigh, creditHigh,creditVeryHigh}
        };

        ruleSet.addRuleMatrix(
                applicant, applicantSets,
                house, houseSets,
                credit, creditMatrix
        );

        // *** Step 2e: TO BE DONE *** //
        // *** uncomment the lines below to check the rules for applicant rating, credit *** //

        //////////// create graphical displays showing the fuzzy inference process
        //////////// for applicant rating, and credit

        //// these would be removed in the final version

        //ruleSet.displayRuleMatrix(
        //    asset, assetSets,
        //    income, incomeSets,
        //    applicant);

        //ruleSet.displayRuleMatrix(
        //    applicant, applicantSets,
        //    house, houseSets,
        //    credit);

        // will print a message if there are gaps
        ruleSet.checkInputVariables();
    }

    /**
     * Sets the market value of the property to mv
     *
     * @param mv is the new market value
     * @throws FuzzyException
     */
    public void setMarketValue(double mv) throws FuzzyException {
        marketValue.setValue(mv);
    }

    /**
     * Sets the location of the property to loc
     *
     * @param loc is the new location
     * @throws FuzzyException
     */
    public void setLocation(double loc) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        location.setValue(loc);
    }

    /**
     * Sets the assets of the applicant to ass
     *
     * @param ass is the new assets
     * @throws FuzzyException
     */
    public void setAsset(double ass) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        asset.setValue(ass);
    }

    /**
     * Sets the income of the applicant to inc
     *
     * @param inc is the new income
     * @throws FuzzyException
     */
    public void setIncome(double inc) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        income.setValue(inc);
    }

    /**
     * Sets the interest rate on the loan to in
     *
     * @param in is the new income
     * @throws FuzzyException
     */
    public void setInterest(double in) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        interest.setValue(in);
    }

    /**
     * Carries out fuzzy inference. Will throw an exception if some
     * input variable is not set, or if some needed intermediate
     * variable does not become set during the inference process.
     *
     * @throws FuzzyException
     */
    public void update() throws FuzzyException {
        // *** Step 2g: TO BE DONE *** //
        ruleSet.update();
    }

    public FuzzyVariablePanel getMarketValuePanel() {
        return new FuzzyVariablePanel(marketValue);
    }

    public FuzzyVariablePanel getLocationPanel() {
        return new FuzzyVariablePanel(location);
    }

    public FuzzyVariablePanel getAssetPanel() {
        return new FuzzyVariablePanel(asset);
    }

    public FuzzyVariablePanel getIncomePanel() {
        return new FuzzyVariablePanel(income);
    }

    public FuzzyVariablePanel getInterestPanel() {
        return new FuzzyVariablePanel(interest);
    }

    public FuzzyVariablePanel getCreditPanel() {
        return new FuzzyVariablePanel(credit);
    }
}
