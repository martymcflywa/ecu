/**
 * Defines AnnulusGrid class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 * 
 * @param setGridSize		sets int gridSize
 * @param setMinX			sets double minX as negative value
 * @param setMaxX			sets double maxX as positive value
 * @param setMinY			sets double minY as negative value
 * @param setMaxY			sets double maxY as positive value
 * 
 * @return getGridSize		gets gridSize
 * @return getGridSq		gets gridSize squared
 * @return getCol			gets centre of column
 * @return getRow			gets centre of row
 * @return getMinX			gets minX
 * @return getMaxX			gets maxX
 * @return getMinY			gets minY
 * @return getMaxY			gets maxY
 * @return getColDelta		gets colDelta
 * @return getRowDelta		gets rowDelta
 */
package annulus.calculator;

class AnnulusGrid {

	// might turn gridSize into final, or ask for user input for desired accuracy
	private int gridSize = 100;
	
	private double minX,
					maxX,
					minY,
					maxY;
	
	void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	
	void setMinX(double minX) {
		this.minX = -minX;
	}
	
	void setMaxX(double maxX) {
		this.maxX = maxX;
	}
	
	void setMinY(double minY) {
		this.minY = -minY;
	}
	
	void setMaxY(double maxY) {
		this.maxY = maxY;
	}
	
	double getGridSize() {
		return gridSize;
	}
	
	double gridSizeSq() {
		return gridSize * gridSize;
	}
	
	double getCol(int col) {
		return minY + (col + 0.5) * ((maxX - minX) / gridSize);
	}

	double getRow(int row) {
		return minY + (row + 0.5) * ((maxY - minY) / gridSize);
	}
	
	double getMinX() {
		return minX;
	}

	double getMaxX() {
		return maxX;
	}

	double getMinY() {
		return minY;
	}

	double getMaxY() {
		return maxY;
	}

	double colDelta() {
		return maxX - minX;
	}
	
	double rowDelta() {
		return maxY - minY;
	}
	
	double iteration() {
		int counter = 0;
		for(int col = 0; col < getGridSize(); col ++){
			double x = getCol(col);
			
			for(int row = 0; row < getGridSize(); row ++) {
				double y = getRow(row);
				double test = x * x + y * y;
				
				if(test < Annulus.rad1Sq() && test > Annulus.rad2Sq()) {
					counter ++;
				}
			}
		}
		return counter;
	}
}
