
public class tmp {
    public static void main() {

        String bin = "111";
        System.out.println(Integer.parseInt(bin, 2));
    }

    public static int fac(int x) {
        if (x > 1) {
            return x * fac(x - 1);
        } else {
            return 1;
        }

    }
}
