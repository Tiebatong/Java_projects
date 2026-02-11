public class Cosinus {
    static void main() {
        System.out.println(cos(3));
    }

    static double cos(double x) {
        double cos = 1;

        for (int i = 0; i < 11; i++) {

            int exponent = 2;
            if (i % 2 == 0) {
                cos -= pow(exponent, x) / fac(exponent);
            } else {
                cos += pow(exponent, x) / fac(exponent);
            }
            exponent += 2;
        }
        return cos;
    }

    static double pow(double exponent, double y) {

        double z = y;
        for (int i = 0; i < exponent - 1; i++) {
            z *= y;
        }
        return z;
    }

    static int fac(int x) {

        int y = 1;
        for (int i = 1; i <= x; i++) {
            y *= i;
        }

        return y;
    }
}
