/**
 * Defines AnnulusGrid class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 * 
 * @param setGridSize		sets int gridSize
 * @param setCol			sets int column
 * @param setRow			sets int row
 * @param setMinX			sets double minX as negative value
 * @param setMaxX			sets double maxX as positive value
 * @param setMinY			sets double minY as negative value
 * @param setMaxY			sets double maxY as positive value
 * 
 * @return getGridSize		gets gridSize
 * @return getCol			gets centre of column
 * @return getRow			gets centre of row
 */
package annulus.calculator;

class AnnulusGrid {

	// might turn gridSize into final, or ask for user input for desired accuracy
	private int gridSize = 100,
				col,
				row;
	
	private double minX,
					maxX,
					minY,
					maxY;
	
	void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	
	void setCol(int col) {
		this.col = col;
	}
	
	void setRow(int row) {
		this.row = row;
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
	
	double getCol(int col) {
		return minY + (col + 0.5) * ((maxX - minX) / gridSize);
	}

	double getRow(int row) {
		return minY + (row + 0.5) * ((maxY - minY) / gridSize);
	}
	

	/**
	 * @return get minX
	 */
	double getMinX() {
		return minX;
	}



	/**
	 * @return get maxx
	 */
	double getMaxX() {
		return maxX;
	}


	/**
	 * @return get minY
	 */
	double getMinY() {
		return minY;
	}


	/**
	 * @return get maxY
	 */
	double getMaxY() {
		return maxY;
	}

	
	/**
	 * @return get column
	 */

	
	/**
	 * @return get row
	 */

	
	/**
	 * @return get columnDelta
	 */
	double colDelta() {
		return maxX - minX;
	}
	
	/**
	 * @return get rowDelta
	 */
	double rowDelta() {
		return maxY - minY;
	}
	
	/**
	 * @return get gridSize squared
	 */
	double gridSizeSq() {
		return gridSize * gridSize;
	}
}
