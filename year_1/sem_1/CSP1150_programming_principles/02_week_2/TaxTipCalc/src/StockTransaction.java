/**
 * Calculate Joe's shady stock transactions
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140802
 */
public class StockTransaction {

// create method to calculate commission, rather than typing it out twice
private static double commissionCalc(double b, double c) {
	return b * c;
}

	public static void main(String[] args) {
		
		// declare COMMISSION and NUMBER_OF_STOCKS constant
		final double COMMISSION = 0.02;
		final double NUMBER_OF_STOCKS = 1000;
		
		// declare variable for buyPrice
		double buyPrice = 32.87;
		
		// calculate buyTotal
		double buyTotal = NUMBER_OF_STOCKS * buyPrice;
		// calculate buyCommission, calls commissionCalc()
		double buyCommission = commissionCalc(buyTotal, COMMISSION);
		
		// declare variable for sellPrice
		double sellPrice = 33.92;
		
		// calculate sellTotal
		double sellTotal = NUMBER_OF_STOCKS * sellPrice;
		// calculate sellCommission, calls commissionCalc()
		double sellCommission = commissionCalc(sellTotal, COMMISSION);
		
		// calculate profit
		double profit = (sellTotal - sellCommission) - (buyTotal - buyCommission);
		
		// output
		System.out.println("Joe paid $" + buyTotal + " when he bought 1000 stocks.");
		System.out.println("Joe paid $" + buyCommission + " of commission to his stockbroker.");
		System.out.println("Two weeks later, Joe decided to sell...");
		System.out.println("Joe sold 1000 stocks for $" + sellTotal);
		System.out.println("Joe paid $" + sellCommission + " of commission to his stockbroker");
		System.out.println("Joe ran off with a profit of $" + profit);
	}
}
