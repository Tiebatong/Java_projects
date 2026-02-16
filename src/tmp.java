
public class tmp {
    public static void main() {

        Matrix matrix = new Matrix(new int[][]{
                {1, 2, 7, 8},
                {2, 6, 5, 3}
        });

         Matrix matrix_B = new Matrix(new int[][] {
                 {2, 8, 9},
                 {1, 12, 15},
                 {42, 3, 6},
                 {50, 21, 4}
         });

        //Matrix m = new Matrix(new int[0][0]);
//        int[][] test = new int[0][0];
//        System.out.println(test.length);
//        System.out.println(test[0].length);

        System.out.println(matrix.multiply(matrix_B));

    }

    public static int fac(int x) {
        if (x > 1) {
            return x * fac(x - 1);
        } else {
            return 1;
        }

    }
}
