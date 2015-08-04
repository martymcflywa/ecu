package csg2341.skynet.ponce.mortgage;

// import gives access to classes in the fuzzy package
//
// remember to add C:\Program Files\java\CSG2341\is.jar under Libraries
//

import au.edu.ecu.is.fuzzy.*;

/**
 * Example program using the fuzzy package to illustrate fuzzy sets
 * derived in class.
 *
 * @author (phi)
 * @version (2007 1)
 */

public class FuzzyExample {
    public static void main(String[] args) throws FuzzyException {
        new FuzzyExample();

        // ctrl-c works if running from a command shell
        //
        // if running from NetBeans, you can use "stop build/run"
        // under the Build menu when done
        //
        System.out.println("Hit ctrl-c to exit");
    }

    public FuzzyExample() throws FuzzyException {
        // We are going to build a fuzzy system

        // We need a ruleset as a container for our fuzzy rules

//        Code to create a Mamdani style one has been commented out
        //MamdaniRuleSet rules = new MamdaniRuleSet();
        // and replaced with code to create a Sugeno style one
        SugenoRuleSet rules = new SugenoRuleSet();

        // to construct the rules, we first need some variables and their fuzzy sets

        // the variable project_funding will have three linguistic values (fuzzy sets)
        FuzzyVariable project_funding = new FuzzyVariable("project funding", "$1,000", 0, 1000, 2);
        FuzzySet inadequate = new FuzzySet("inadequate", 0, 0, 50, 100);
        //inadequate.display();
        FuzzySet marginal = new FuzzySet("marginal", 50, 300, 300, 750);
        //marginal.display();
        FuzzySet adequate = new FuzzySet("adequate", 500, 750, 1000, 1000);
        //adequate.display();
        project_funding.add(inadequate);
        project_funding.add(marginal);
        project_funding.add(adequate);
        project_funding.display();

        FuzzyVariable project_staffing = new FuzzyVariable("project staffing", "# people", 1, 100, 0);
        FuzzySet small = new FuzzySet("small staff", 1, 1, 10, 20);
        FuzzySet medium = new FuzzySet("medium staff", 10, 20, 20, 50);
        FuzzySet large = new FuzzySet("large staff", 10, 50, 100, 100);
        project_staffing.add(small);
        project_staffing.add(medium);
        project_staffing.add(large);
        project_staffing.display();

        FuzzyVariable risk = new FuzzyVariable("risk", "rating", 0, 10, 0);
        FuzzySet low_risk = new FuzzySet("low", 0, 0, 4, 10);
        FuzzySet normal = new FuzzySet("normal", 3, 6, 6, 8);
        FuzzySet high_risk = new FuzzySet("high", 6, 8, 10, 10);
        risk.add(low_risk);
        risk.add(normal);
        risk.add(high_risk);
        risk.display();

        // RULE:if project_funding is marginal and project_staffing is large then risk is normal
//        rules.addRule(project_funding, marginal, project_staffing, large, risk, normal);
        rules.addRule(project_funding, marginal, project_staffing, large, risk, new FuzzySpike(risk, 6.0));

        // RULE: if project_funding is inadequate then risk is high
//        rules.addRule(project_funding, inadequate, risk, high_risk);
        rules.addRule(project_funding, inadequate, risk, new FuzzySpike(risk, 10));

        // RULE: if project_funding is adequate or project staffing is small then risk is small
        // we have split this into two rules:

        // RULE: if project_funding is adequate then risk is small
        // Here the rule is created as a separate object before being added to the ruleset.
        // This can be useful if you want to use this object - e.g. call its display() method

//        MamdaniRule ruleA = new MamdaniRule(risk, low_risk);
//        ruleA.addCondition(project_funding, adequate);
//        rules.addRule(ruleA);
        SugenoRule ruleA = new SugenoRule(risk, 2);
        ruleA.addCondition(project_funding, adequate);
        rules.addRule(ruleA);

        // and
        // RULE: if project_staffing is small then risk is low
//        rules.addRule(project_staffing, small, risk, low_risk);
        rules.addRule(project_staffing, small, risk, new FuzzySpike(risk, 2));

        rules.displayRulesFor(risk);
    }
}
