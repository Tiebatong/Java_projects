public class Matrix {

    private int[][] matrix;

    Matrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        if (matrix.length == 0) {
            throw new IllegalArgumentException("empty matrix");
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i] == null || matrix[i + 1] == null) {
                throw new IllegalArgumentException("row is null");
            }
            if (matrix[i].length != matrix[i + 1].length) {
                throw new IllegalArgumentException("matrix is not a rectangle");

            }
        }

        int [][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        this.matrix = temp;
    }

    int get(int row, int column) {


        try {
            return this.matrix[row][column];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("index not valid");
        }

    }

    Matrix multiply(Matrix matrix) {

        if (this.matrix == null || matrix == null) {
            throw new IllegalArgumentException("cant multiply matrices");
        }
        if (this.matrix[0].length != matrix.matrix.length) {
            throw new IllegalArgumentException("cant multiply matrices");
        }

        int [][] product = new int[this.matrix.length][matrix.matrix[0].length];

        for (int i = 0; i < product[0].length; i++) {
            for (int j = 0; j < product.length; j++) {
                int sum = 0;

                for (int k = 0; k < this.matrix[0].length; k++) {
                    sum += this.matrix[j][k] * matrix.matrix[k][i];
                }
                product[j][i] = sum;
            }

        }
        Matrix temp = new Matrix(product);
        return temp;
    }

    @Override
    public String toString() {

        if (this.matrix == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        String string_representation = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                string_representation += matrix[i][j] + " ";
            }
            string_representation += "\n";
        }
        return string_representation;
    }
}
