public class Cosinus {
    static void main() {
        System.out.println(cos(3.5));
    }

    static double cos(double x) {
        double cos = 0;

        for (int i = 0; i < 10; i++) {

        cos += (pow(i, -1) / fac(2 * i)) * pow(2 * i, x);
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
