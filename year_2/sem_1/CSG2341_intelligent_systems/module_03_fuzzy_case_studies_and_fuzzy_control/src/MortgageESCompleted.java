import au.edu.ecu.is.fuzzy.*;

/**
 * Example solution for the Mortgage expert system.
 * CSG2341 Intelligent Systems, Workshop 2
 *
 * @author (phi)
 * @version (2006/2)
 */
public class MortgageESCompleted
{
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
    public static void main(String[] args) throws FuzzyException
    {
        new MortgageESCompleted();
    }
    
   /**
     * Constructor for a mortgage expert system instance
     *
     * @throws FuzzyException - shouldn't though
     */
    public MortgageESCompleted() throws FuzzyException
    {
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
        // check for gaps in the fuzzy sets for this input variable
        marketValue.checkGaps();
        // for illustrative/diagnostic purposes, display the variable graphically
        // should be removed from the final version
        //marketValue.display();
        
        /////////////////// now do likewise for the other fuzzy variables ///////////////////
        
        location = new FuzzyVariable("location", "rating", 0.0, 10.0, 1);
        FuzzySet locBad = new FuzzySet("bad", 0.0, 0.0, 1.5, 4.0);
        FuzzySet locFair = new FuzzySet("fair", 2.5, 5.0, 6.0, 8.5);
        FuzzySet locExcellent = new FuzzySet("excellent", 6.0, 8.5, 10.0, 10.0);
        location.add(locBad);
        location.add(locFair);
        location.add(locExcellent);
        location.checkGaps();
        
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
        house.checkGaps();
        
        asset = new FuzzyVariable("assets", "$000's", 0.0, 1000.0, 3);
        FuzzySet assetLow = new FuzzySet("low", 0.0, 0.0, 0.0, 150.0);
        FuzzySet assetMedium = new FuzzySet("medium", 50.0, 250.0, 450.0, 650.0);
        FuzzySet assetHigh = new FuzzySet("high", 500.0, 700.0, 1000.0, 1000.0);
        asset.add(assetLow);
        asset.add(assetMedium);
        asset.add(assetHigh);
        asset.checkGaps();
        
        income = new FuzzyVariable("income", "$000's", 0.0, 100.0, 3);
        FuzzySet incomeLow = new FuzzySet("low", 0.0, 0.0, 15.0, 25.0);
        FuzzySet incomeMedium = new FuzzySet("medium", 15.0, 35.0, 35.0, 55.0);
        FuzzySet incomeHigh = new FuzzySet("high", 40.0, 60.0, 60.0, 80.0);
        FuzzySet incomeVeryHigh = new FuzzySet("very high", 60.0, 80.0, 100.0, 100.0);
        income.add(incomeLow);
        income.add(incomeMedium);
        income.add(incomeHigh);
        income.add(incomeVeryHigh);
        income.checkGaps();
        
        applicant = new FuzzyVariable("applicant", "rating", 0.0, 10.0, 1);
        FuzzySet applicantLow = new FuzzySet("low", 0.0, 0.0, 2.0, 4.0);
        FuzzySet applicantMedium = new FuzzySet("medium", 2.0, 5.0, 5.0, 8.0);
        FuzzySet applicantHigh = new FuzzySet("high", 6.0, 8.0, 10.0, 10.0);
        applicant.add(applicantLow);
        applicant.add(applicantMedium);
        applicant.add(applicantHigh);
        applicant.checkGaps();
        
        interest = new FuzzyVariable("interest", "%", 0.0, 10.0, 2);
        FuzzySet interestLow = new FuzzySet("low", 0.0, 0.0, 2.0, 5.0);
        FuzzySet interestMedium = new FuzzySet("medium", 2.0, 4.0, 6.0, 8.0);
        FuzzySet interestHigh = new FuzzySet("high", 6.0, 8.5, 10.0, 10.0);
        interest.add(interestLow);
        interest.add(interestMedium);
        interest.add(interestHigh);
        interest.checkGaps();
        
        credit = new FuzzyVariable("credit", "$000's", 0.0, 500.0, 3);
        FuzzySet creditVeryHigh = new FuzzySet("very high", 375.0, 500.0, 500.0, 500.0);
        FuzzySet creditHigh = new FuzzySet("high", 250.0, 375.0, 375.0, 500.0);
        FuzzySet creditMedium = new FuzzySet("medium", 125.0, 250.0, 250.0, 375.0);
        FuzzySet creditLow = new FuzzySet("low", 0.0, 125.0, 125.0, 250.0);
        FuzzySet creditVeryLow = new FuzzySet("very low", 0.0, 0.0, 0.0, 125.0);
        credit.add(creditVeryHigh);
        credit.add(creditHigh);
        credit.add(creditMedium);
        credit.add(creditLow);
        credit.add(creditVeryLow);
        credit.checkGaps();
        
        ////////// now create and add fuzzy rules //////////////////////////////////////
        
        // Home evaluation rules
        
        // if (market value is low) then (house is low)
        ruleSet.addRule(marketValue, mvLow, house, houseLow);
        
        // if (location is bad) then (house is low)
        ruleSet.addRule(location, locBad, house, houseLow);
        
        // here we add a matrix of rules about house ratings for all
        // combinations of location and market value
        FuzzySet[] locationSets = {locBad, locFair, locExcellent};
        FuzzySet[] mvSets = {mvLow, mvMedium, mvHigh, mvVeryHigh};
        FuzzySet[][] houseMatrix =
        {
            {houseVeryLow, houseLow, houseMedium, houseHigh},
            {houseLow, houseMedium, houseHigh, houseVeryHigh},
            {houseMedium, houseHigh, houseVeryHigh, houseVeryHigh}
        };
        
        ruleSet.addRuleMatrix(
                location, locationSets,
                marketValue, mvSets,
                house, houseMatrix
                );
        
        // Applicant evaluation rules
        
        FuzzySet[] assetSets = {assetLow, assetMedium, assetHigh};
        FuzzySet[] incomeSets = {incomeLow, incomeMedium, incomeHigh, incomeVeryHigh};
        FuzzySet[][] applicantMatrix =
        {
            {applicantLow, applicantLow, applicantMedium, applicantHigh},
            {applicantLow, applicantMedium, applicantHigh, applicantHigh},
            {applicantMedium, applicantMedium, applicantHigh, applicantHigh}
        };
        
        ruleSet.addRuleMatrix(
                asset, assetSets,
                income, incomeSets,
                applicant, applicantMatrix
                );
        
        // Credit rules
        
        // if (income is low) and (interest is medium) then (credit is very low)
        ruleSet.addRule(income, incomeLow, interest, interestMedium, credit, creditVeryLow);
        // if (income is low) and (interest is high) then (credit is very low)
        ruleSet.addRule(income, incomeLow, interest, interestHigh, credit, creditVeryLow);
        // if (income is medium) and (interest is high) then (credit is low)
        ruleSet.addRule(income, incomeMedium, interest, interestHigh, credit, creditLow);
        // if (house is very low) then (credit is very low)
        ruleSet.addRule(house, houseVeryLow, credit, creditVeryLow);
        // if (applicant is low) then (credit is very low)
        ruleSet.addRule(applicant, applicantLow, credit, creditVeryLow);
        
        FuzzySet[] applicantSets = {applicantMedium,applicantHigh};
        FuzzySet[] houseSets = {houseVeryLow, houseLow, houseMedium, houseHigh, houseVeryHigh};
        FuzzySet[][] creditMatrix =
        {
            {creditLow, creditLow, creditMedium, creditHigh, creditHigh},
            {creditLow, creditMedium, creditHigh, creditHigh, creditVeryHigh}
        };
        ruleSet.addRuleMatrix(
                applicant, applicantSets,
                house, houseSets,
                credit, creditMatrix
                );
        
        //////////// create graphical displays showing the fuzzy inference process
        //////////// for house rating, applicant rating, and credit
        
        // these would be removed in the final version
        
        //// this creates a matrix-based display
        ruleSet.displayRuleMatrix(
                location, locationSets,
                marketValue, mvSets,
                house);
        
        // the following alternative creates a scrolling list of all rules determining house rating
        //(new FuzzyRuleSubsetPanel(ruleSet, house)).display();
        
        ruleSet.displayRuleMatrix(
                asset, assetSets,
                income, incomeSets,
                applicant);
        
        ruleSet.displayRuleMatrix(
                applicant, applicantSets,
                house, houseSets,
                credit);
    }
    
    /**
       Sets the market value of the property to mv

       @param mv is the new market value
       @throws FuzzyException
    */
    public void setMarketValue(double mv) throws FuzzyException 
    {
        marketValue.setValue(mv);
    }
       
    /**
       Sets the location of the property to loc

       @param loc is the new location
       @throws FuzzyException
    */
    public void setLocation(double loc) throws FuzzyException 
    {
        location.setValue(loc);
    }
       
    /**
       Sets the assets of the applicant to ass

       @param ass is the new assets
       @throws FuzzyException
    */
    public void setAsset(double ass) throws FuzzyException 
    {
        asset.setValue(ass);
    }
       
    /**
       Sets the income of the applicant to inc

       @param inc is the new income
       @throws FuzzyException
    */
    public void setIncome(double inc) throws FuzzyException
    {
        income.setValue(inc);
    }

    /**
       Sets the interest rate on the loan to in

       @param inc is the new income
       @throws FuzzyException
    */
    public void setInterest(double in) throws FuzzyException
    {
        interest.setValue(in);
    }
    
    /**
     * Carries out fuzzy inference. Will throw an exception if some
     * input variable is not set, or if some needed intermediate
     * variable does not become set during the inference process.
     *
     * @throws FuzzyException
     */
    public void update() throws FuzzyException
    {
        ruleSet.update();
    }

    public FuzzyVariablePanel getMarketValuePanel()
    {
        return new FuzzyVariablePanel(marketValue);
    }
    
    public FuzzyVariablePanel getLocationPanel()
    {
        return new FuzzyVariablePanel(location);
    }
    
    public FuzzyVariablePanel getAssetPanel()
    {
        return new FuzzyVariablePanel(asset);
    }
    
    public FuzzyVariablePanel getIncomePanel()
    {
        return new FuzzyVariablePanel(income);
    }
    
    public FuzzyVariablePanel getInterestPanel()
    {
        return new FuzzyVariablePanel(interest);
    }
    
    public FuzzyVariablePanel getCreditPanel()
    {
        return new FuzzyVariablePanel(credit);
    }
}
