import au.edu.ecu.is.fuzzy.*;

/**
 * Partial solution for the Mortgage expert system.
 * CSG2341 Intelligent Systems, Workshop 2
 * <p/>
 * Parts to be completed are indicated by comments in the code.
 * <p/>
 * Note - the program will compile and run without changes, but will not give sensible results.
 *
 * @author (phi)
 * @version (2015/2)
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
        //System.out.println(marketValue.checkGaps());
        // for illustrative/diagnostic purposes, display the variable graphically
        // (should be removed from the final version)
        //marketValue.display();

        /////////////////// now do likewise for the other fuzzy variables ///////////////////

        // *** Step 2c: TO BE COMPLETED *** //
        // *** add the missing parameters and uncomment the code *** //
        // *** also fix the "set" methods below *** //

        //location = new FuzzyVariable("location", "rating", 0.0, 10.0, 1);
        //FuzzySet locBad = new FuzzySet("bad", , , , );
        //FuzzySet locFair = new FuzzySet("fair", , , , );
        //FuzzySet locExcellent = new FuzzySet("excellent", , , , );
        //location.add(locBad);
        //location.add(locFair);
        //location.add(locExcellent);
        //location.display();

        //house = new FuzzyVariable(, , , , );
        //FuzzySet houseVeryLow = new FuzzySet(, , , , );
        //FuzzySet houseLow = new FuzzySet(, , , , );
        //FuzzySet houseMedium = new FuzzySet(, , , , );
        //FuzzySet houseHigh = new FuzzySet(, , , , );
        //FuzzySet houseVeryHigh = new FuzzySet(, , , , );
        //house.add(houseVeryLow);
        //house.add(houseLow);
        //house.add(houseMedium);
        //house.add(houseHigh);
        //house.add(houseVeryHigh);
        //house.display();

        //asset = new FuzzyVariable(, , , , );
        //FuzzySet assetLow = new FuzzySet(, , , , );
        //FuzzySet assetMedium = new FuzzySet(, , , , );
        //FuzzySet assetHigh = new FuzzySet(, , , , );
        //asset.add(assetLow);
        //asset.add(assetMedium);
        //asset.add(assetHigh);

        //income = new FuzzyVariable(, , , , );
        //FuzzySet incomeLow = new FuzzySet(, , , , );
        //FuzzySet incomeMedium = new FuzzySet(, , , , );
        //FuzzySet incomeHigh = new FuzzySet(, , , , );
        //FuzzySet incomeVeryHigh = new FuzzySet(, , , , );
        //income.add(incomeLow);
        //income.add(incomeMedium);
        //income.add(incomeHigh);
        //income.add(incomeVeryHigh);

        //applicant = new FuzzyVariable(, , , , );
        //FuzzySet applicantLow = new FuzzySet(, , , , );
        //FuzzySet applicantMedium = new FuzzySet(, , , , );
        //FuzzySet applicantHigh = new FuzzySet(, , , , );
        //applicant.add(applicantLow);
        //applicant.add(applicantMedium);
        //applicant.add(applicantHigh);

        //interest = new FuzzyVariable(, , , , );
        //FuzzySet interestLow = new FuzzySet(, , , , );
        //FuzzySet interestMedium = new FuzzySet(, , , , );
        //FuzzySet interestHigh = new FuzzySet(, , , , );
        //interest.add(interestLow);
        //interest.add(interestMedium);
        //interest.add(interestHigh);

        //credit = new FuzzyVariable(, , , , );
        //FuzzySet creditVeryHigh = new FuzzySet(, , , , );
        //FuzzySet creditHigh = new FuzzySet(, , , , );
        //FuzzySet creditMedium = new FuzzySet(, , , , );
        //FuzzySet creditLow = new FuzzySet(, , , , );
        //FuzzySet creditVeryLow = new FuzzySet(, , , , );
        //credit.add(creditVeryHigh);
        //credit.add(creditHigh);
        //credit.add(creditMedium);
        //credit.add(creditLow);
        //credit.add(creditVeryLow);

        ////////// now create and add fuzzy rules //////////////////////////////////////

        //// Home evaluation rules

        // *** Step 2d: TO BE COMPLETED *** //
        // *** uncomment the house rating rules *** //

        //// if (market value is low) then (house is low)
        //ruleSet.addRule(marketValue, mvLow, house, houseLow);

        //// if (location is bad) then (house is low)
        //ruleSet.addRule(location, locBad, house, houseLow);

        // here we add a matrix of rules about house ratings for all
        // combinations of location and market value
        //FuzzySet[] locationSets = {locBad, locFair, locExcellent};
        //FuzzySet[] mvSets = {mvLow, mvMedium, mvHigh, mvVeryHigh};
        //FuzzySet[][] houseMatrix =
        //    {
        //        {houseVeryLow, houseLow, houseMedium, houseHigh},
        //        {houseLow, houseMedium, houseHigh, houseVeryHigh},
        //        {houseMedium, houseHigh, houseVeryHigh, houseVeryHigh}
        //    };

        //ruleSet.addRuleMatrix(
        //    location, locationSets,
        //    marketValue, mvSets,
        //    house, houseMatrix
        //    );

        //////////// create graphical display showing the fuzzy inference process
        //////////// for house rating

        //// this would be removed in the final version

        //// this creates a matrix-based display
        //ruleSet.displayRuleMatrix(
        //		location, locationSets,
        //		marketValue, mvSets,
        //		house);

        //// the following alternative creates a scrolling list of all rules determining house rating
        //(new FuzzyRuleSubsetPanel(ruleSet, house)).display();

        // *** Step 2e: TO BE COMPLETED *** //
        // *** complete uncomment the remaining rules *** //
        // *** and uncomment the "update" and "get" methods below *** //

        //// Applicant evaluation rules

        //FuzzySet[] assetSets = {assetLow, assetMedium, assetHigh};
        //FuzzySet[] incomeSets = {incomeLow, incomeMedium, incomeHigh, incomeVeryHigh};
        //FuzzySet[][] applicantMatrix =
        //    {
        //        {applicantLow, applicantLow, applicantMedium, applicantHigh},
        //        { , , , },
        //        {, , , }
        //    };

        //ruleSet.addRuleMatrix(
        //    asset, assetSets,
        //    income, incomeSets,
        //    applicant, applicantMatrix
        //    );

        //// Credit rules

        //// if (income is low) and (interest is medium) then (credit is very low)
        //ruleSet.addRule(income, incomeLow, interest, interestMedium, credit, creditVeryLow);
        //// if (income is low) and (interest is high) then (credit is very low)
        //ruleSet.addRule(, , , , , );
        //// if (income is medium) and (interest is high) then (credit is low)
        //ruleSet.addRule(, , , , , );
        //// if (house is very low) then (credit is very low)
        //ruleSet.addRule(, , , , , );
        //// if (applicant is low) then (credit is very low)
        //ruleSet.addRule(, , , );

        //FuzzySet[] applicantSets = {applicantMedium,applicantHigh};
        //FuzzySet[] houseSets = {houseVeryLow, houseLow, houseMedium, houseHigh, houseVeryHigh};
        //FuzzySet[][] creditMatrix =
        //    {
        //        {creditLow, creditLow, creditMedium, creditHigh, creditHigh},
        //        {, , , , }
        //    };
        //ruleSet.addRuleMatrix(
        //    applicant, applicantSets,
        //    house, houseSets,
        //    credit, creditMatrix
        //    );

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
        //location.setValue(loc);
    }

    /**
     * Sets the assets of the applicant to ass
     *
     * @param ass is the new assets
     * @throws FuzzyException
     */
    public void setAsset(double ass) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        //asset.setValue(ass);
    }

    /**
     * Sets the income of the applicant to inc
     *
     * @param inc is the new income
     * @throws FuzzyException
     */
    public void setIncome(double inc) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        //income.setValue(inc);
    }

    /**
     * Sets the interest rate on the loan to in
     *
     * @param in is the new income
     * @throws FuzzyException
     */
    public void setInterest(double in) throws FuzzyException {
        // *** Step 2c: TO BE DONE *** //
        //interest.setValue(in);
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
        //ruleSet.update();
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
