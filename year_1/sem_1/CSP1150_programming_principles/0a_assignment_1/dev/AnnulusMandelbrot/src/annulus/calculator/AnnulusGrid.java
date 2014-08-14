/**
 * Defines AnnulusGrid class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 */
package annulus.calculator;

class AnnulusGrid {

	// might turn gridSize into final, or ask for user input for desired accuracy
	private double gridSize = 100.0,
			minX,
			maxX,
			minY,
			maxY,
			column,
			row;

	/**
	 * @return get gridSize
	 */
	double getGridSize() {
		return gridSize;
	}

	/**
	 * @param set gridSize
	 */
	void setGridSize(double gridSize) {
		this.gridSize = gridSize;
	}

	/**
	 * @return get minX
	 */
	double getMinX() {
		return minX;
	}

	/**
	 * @param set minX
	 */
	void setMinX(double minX) {
		this.minX = -minX;
	}

	/**
	 * @return get maxx
	 */
	double getMaxX() {
		return maxX;
	}

	/**
	 * @param set maxX
	 */
	void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	/**
	 * @return get minY
	 */
	double getMinY() {
		return minY;
	}

	/**
	 * @param set minY
	 */
	void setMinY(double minY) {
		this.minY = -minY;
	}

	/**
	 * @return get maxY
	 */
	double getMaxY() {
		return maxY;
	}

	/**
	 * @param set maxY
	 */
	void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	/**
	 * @return get column
	 */
	double getColumn() {
		return column;
	}

	/**
	 * @param set column
	 */
	void setColumn(double column) {
		this.column = column;
	}

	/**
	 * @return get row
	 */
	double getRow() {
		return row;
	}

	/**
	 * @param set row
	 */
	void setRow(double row) {
		this.row = row;
	}
	
	/**
	 * @return get column
	 */
	double getColumn(double column) {
		return minY + (column + 0.5) * ((maxX - minX) / gridSize);
	}
	
	/**
	 * @return get row
	 */
	double getRow(double row) {
		return minY + (row + 0.5) * ((maxY - minY) / gridSize);
	}
	
	/**
	 * @return get columnDelta
	 */
	double columnDelta() {
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
