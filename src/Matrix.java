public class Matrix {

    private int[][] matrix;



    Matrix(int[][] matrix) {

        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException();
        }
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    int get(int row, int column) {

        if (this.matrix.length < row || this.matrix[0].length < column) {
            throw new IndexOutOfBoundsException();
        }

        return this.matrix[row][column];
    }

    Matrix multiply(Matrix m) {

        if (this.matrix[0].length != m.matrix.length || m == null) {
            throw new IllegalArgumentException("test");
        }

        int[][] returnMatrix = new int[this.matrix.length][m.matrix[0].length];

        for (int i = 0; i < returnMatrix.length; i++) {
            for (int j = 0; j < returnMatrix[0].length; j++) {
                for (int k = 0; k < this.matrix[0].length; k++) {
                    returnMatrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }


        Matrix M = new Matrix(returnMatrix);
        return M;
    }

    @Override

    public String toString() {
        String toString = "";

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                toString += this.matrix[i][j] + " ";
            }
            toString += "\n";
        }
        return toString;
    }

    boolean isMatrix(int[][] matrix) {

        for (int[] row: matrix) {
            if (row == null || matrix[0].length != row.length) {
                return false;
            }
        }


        return true;
    }
}
