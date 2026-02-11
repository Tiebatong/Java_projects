public class Balistic {

    static void main() {

        System.out.println(balistic(1.5, 2, 10));
    }

    static double balistic(double t, double x0, double v0) {

        double g = 9.81;

        return x0 + v0 * t - (g * (t * t) / 2);
    }
}
