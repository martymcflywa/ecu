/**
 * Defines static AnnulusGrid class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 * 
 * @param setGridSize		sets int gridSize
 * @param setMin			sets minX and minY as negative value
 * @param setMax			sets maxX and maxY as positive value
 * 
 * @return getGridSize		gets gridSize
 * @return getGridSq		gets gridSize squared
 * @return getCol			gets centre of column
 * @return getRow			gets centre of row
 * @return getColRandom		gets column random hitpoints
 * @return getRowRandom		gets row random hitpoints
 * @return getMinX			gets minX
 * @return getMaxX			gets maxX
 * @return getMinY			gets minY
 * @return getMaxY			gets maxY
 * @return getColDelta		gets colDelta
 * @return getRowDelta		gets rowDelta
 * @return iterator			iterates through fixed centred hitpoint
 * @return hitsIterator		iterates through random hitpoints
 */
package annulus.calculator;

class AnnulusGrid {

	private static int gridSize = 100,
						samples = 100,
						col,
						row;
	
	private static double minX,
					maxX,
					minY,
					maxY;
	
	static void setGridSize(int gridSize) {
		AnnulusGrid.gridSize = gridSize;
	}
	
	static void setMin(double min) {
		AnnulusGrid.minX = -min;
		AnnulusGrid.minY = -min;
		
	}
	
	static void setMax(double max) {
		AnnulusGrid.maxX = max;
		AnnulusGrid.maxY = max;
	}
	
	static double getGridSize() {
		return gridSize;
	}
	
	static double gridSizeSq() {
		return gridSize * gridSize;
	}
	
	static double getCol(int col) {
		return minX + (col + 0.5) * ((maxX - minX) / gridSize);
	}
	
	static double getColRandom(int col) {
		AnnulusGrid.col = AnnulusGrid.col ++;
		return minX + (col + Math.random()) * ((maxX - minX) / gridSize);
	}

	static double getRow(int row) {
		return minY + (row + 0.5) * ((maxY - minY) / gridSize);
	}
	
	static double getRowRandom(int row) {
		AnnulusGrid.row = AnnulusGrid.row ++;
		return minY + (row + Math.random()) * ((maxY - minY) / gridSize);
	}
	
	static double getMinX() {
		return minX;
	}

	static double getMaxX() {
		return maxX;
	}

	static double getMinY() {
		return minY;
	}

	static double getMaxY() {
		return maxY;
	}

	static double colDelta() {
		return maxX - minX;
	}
	
	static double rowDelta() {
		return maxY - minY;
	}
	
	static int iterator() {
		int counter = 0;
		
		for(int col = 0; col < gridSize - 1; col ++) {
			double x = getCol(col);
			
			for(int row = 0; row < gridSize - 1; row ++) {
				double y = getRow(row);
				double test = x * x + y * y;
				
				if(test < Annulus.rad1Sq() && test > Annulus.rad2Sq()) {
					counter ++;
				}
			}
		}
		return counter;
	}
	
	// need to figure out how to expand array
	static double hitsIterator() {
		double counter = 0.0;
		double[][] hits = new double[gridSize][gridSize];
		
		for(int i = 0; i < gridSize - 1; i ++) {
			
			for(int j = 0; j < gridSize - 1; j ++) {
				
				for(int k = 0; k < samples; k ++) {
					
					double x = getColRandom(i);
					double y = getRowRandom(j);
					double test = x * x + y * y;
					
					if(test < Annulus.rad1Sq() && test > Annulus.rad2Sq()) {
						hits[i][j] = 1;
					}			
				}
				//hits[i][j] = hits[i][j] / samples;
				counter = counter + hits[i][j];	
			}
		}
		return counter;
	}
}