
public class tmp {
    public static void main() {

        System.out.println(fac(5));
    }

    public static int fac(int x) {
        if (x > 1) {
            return x * fac(x - 1);
        } else {
            return 1;
        }

    }
}
