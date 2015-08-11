import au.edu.ecu.is.fuzzy.*;

/**
 * The spare parts expert system.
 *
 * @author phi
 * @version 2004/2
 */
public class SparePartsESCompleted {
    public SparePartsESCompleted() throws Exception {
        ruleSet = new MamdaniRuleSet();

        meanDelay = new FuzzyVariable("mean delay", "(normalised)", 0.0, 0.7, 2);

        FuzzySet mdVeryShort = new FuzzySet("very short", 0.0, 0.0, 0.1, 0.3);
        FuzzySet mdShort = new FuzzySet("short", 0.1, 0.3, 0.3, 0.5);
        FuzzySet mdMedium = new FuzzySet("medium", 0.4, 0.6, 0.7, 0.7);

        meanDelay.add(mdVeryShort);
        meanDelay.add(mdShort);
        meanDelay.add(mdMedium);

        nServers = new FuzzyVariable("number of servers", "(normalised)", 0.0, 1.0, 2);

        FuzzySet nsSmall = new FuzzySet("small", 0.0, 0.0, 0.15, 0.35);
        FuzzySet nsMedium = new FuzzySet("medium", 0.3, 0.5, 0.5, 0.7);
        FuzzySet nsLarge = new FuzzySet("large", 0.6, 0.8, 1.0, 1.0);

        nServers.add(nsSmall);
        nServers.add(nsMedium);
        nServers.add(nsLarge);

        repairUtilisationFactor = new FuzzyVariable("repair utilisation", "", 0.0, 1.0, 2);

        FuzzySet rufLow = new FuzzySet("low", 0.0, 0.0, 0.4, 0.6);
        FuzzySet rufMedium = new FuzzySet("medium", 0.4, 0.6, 0.6, 0.8);
        FuzzySet rufHigh = new FuzzySet("high", 0.6, 0.8, 1.0, 1.0);

        repairUtilisationFactor.add(rufLow);
        repairUtilisationFactor.add(rufMedium);
        repairUtilisationFactor.add(rufHigh);

        nSpares = new FuzzyVariable("number of spares", "(normalised)", 0.0, 1.0, 2);

        FuzzySet nspVerySmall = new FuzzySet("very small", 0.0, 0.0, 0.1, 0.3);
        FuzzySet nspSmall = new FuzzySet("small", 0.0, 0.2, 0.2, 0.4);
        FuzzySet nspRatherSmall = new FuzzySet("rather small", 0.25, 0.35, 0.35, 0.45);
        FuzzySet nspMedium = new FuzzySet("medium", 0.3, 0.5, 0.5, 0.7);
        FuzzySet nspRatherLarge = new FuzzySet("rather large", 0.55, 0.65, 0.65, 0.75);
        FuzzySet nspLarge = new FuzzySet("large", 0.6, 0.8, 0.8, 1.0);
        FuzzySet nspVeryLarge = new FuzzySet("very large", 0.7, 0.9, 1.0, 1.0);

        nSpares.add(nspVerySmall);
        nSpares.add(nspSmall);
        nSpares.add(nspRatherSmall);
        nSpares.add(nspMedium);
        nSpares.add(nspRatherLarge);
        nSpares.add(nspLarge);
        nSpares.add(nspVeryLarge);

        FuzzySet[] delaySets = {mdVeryShort, mdShort, mdMedium};
        FuzzySet[] serverSets = {nsSmall, nsMedium, nsLarge};
        FuzzySet[] repairSets = {rufLow, rufMedium, rufHigh};

        FuzzySet[][][] spareSets =
                {
                        {
                                {nspSmall, nspSmall, nspVerySmall},
                                {nspVerySmall, nspVerySmall, nspVerySmall},
                                {nspVerySmall, nspVerySmall, nspVerySmall}
                        },
                        {
                                {nspMedium, nspRatherSmall, nspSmall},
                                {nspRatherSmall, nspSmall, nspVerySmall},
                                {nspSmall, nspVerySmall, nspVerySmall}
                        },
                        {
                                {nspRatherLarge, nspMedium, nspRatherSmall},
                                {nspMedium, nspMedium, nspSmall},
                                {nspVeryLarge, nspLarge, nspMedium}
                        }
                };

        ruleSet.add3DRuleMatrix(
                meanDelay, delaySets,
                nServers, serverSets,
                repairUtilisationFactor, repairSets,
                nSpares, spareSets);

        ruleSet.display3DRuleMatrix(
                meanDelay, delaySets,
                nServers, serverSets,
                repairUtilisationFactor, repairSets,
                nSpares);

        ruleSet.checkInputVariables();
    }

    public void test(double md, double ns, double ru) throws Exception {
        ruleSet.clearVariables();

        meanDelay.setValue(md);
        nServers.setValue(ns);
        repairUtilisationFactor.setValue(ru);

        ruleSet.update();

        System.out.println(nSpares);
    }

    public static void main(String[] args) throws Exception {
        (new SparePartsESCompleted()).test(0.5, 0.5, 0.5);
    }

    private MamdaniRuleSet ruleSet;
    private FuzzyVariable meanDelay;
    private FuzzyVariable nServers;
    private FuzzyVariable repairUtilisationFactor;
    private FuzzyVariable nSpares;
}
