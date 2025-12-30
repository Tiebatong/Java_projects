public class tmp {
    public static void main(String[] args) {


        int[][] m = {
                {1,2,7,8},
                {2,6,5,3}
        };

        int[][] x = {
                {2,8,9},
                {1,12,15},
                {42,3,6},
                {50,21,4}
        };

        Matrix m1 = new Matrix(m);
        Matrix m2 = new Matrix(x);


        Matrix muliplyed = m1.multiply(m2);
        System.out.println(muliplyed);


    }

}
