package test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addCalcListener(new CalcListener());
	}
	
	class CalcListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			double outRadius = 0.0;
			double inRadius = 0.0;
			
			try {
				outRadius = theView.getOutRadius();
				inRadius = theView.getInRadius();
				
				theModel.calcApprox(outRadius, inRadius);
				
				theView.setAreaApprox(theModel.getAreaApprox());
			}
			
			catch(NumberFormatException ex) {
				theView.displayErrorMessage("Enter two values.");
			}
		}
	}
}
