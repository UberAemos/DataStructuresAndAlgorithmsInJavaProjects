package projects.fundamental;

/**
 * A matrix that can add and multiply arbitrary two dimensional arrays of integers.
 */
public class Matrix {

    /**
     * Two dimensional array for storing data
     */
    int[][] data;

    /**
     * Constructor
     */
    public Matrix(int numRows, int numColumns) {
        if (numRows * numColumns <= 0)
            throw new IllegalArgumentException("Number of rows and columns must be larger than 0");
        data = new int[numRows][numColumns];
    }

    /**
     * Adds given matrix to the current matrix
     */
    public void addMatrix(Matrix secondMatrix) {
        if (isMatrixInSameStructure(secondMatrix)) {
            for (int i = 0; i < this.data.length; i++)
                for (int j = 0; j < this.data[i].length; j++) {
                    this.data[i][j] = this.data[i][j] + secondMatrix.data[i][j];
                }
        } else
            throw new IllegalArgumentException("Matrix structures should be the same");
    }

    /**
     * Multiplies the given matrix with the current matrix
     */
    public void multiplyMatrix(Matrix secondMatrix) {
        if (isMatrixInSameStructure(secondMatrix)) {
            for (int i = 0; i < this.data.length; i++)
                for (int j = 0; j < this.data[i].length; j++) {
                    this.data[i][j] = this.data[i][j] * secondMatrix.data[i][j];
                }
        } else
            throw new IllegalArgumentException("Matrix structures should be the same");
    }

    private boolean isMatrixInSameStructure(Matrix secondMatrix) {
        return this.data.length == secondMatrix.data.length &&
                this.data[0].length == secondMatrix.data[0].length;
    }
}
