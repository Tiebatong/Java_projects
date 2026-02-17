
public class tmp {
    public static void main() {

    int[] a0 = {2, 0, 5};
    int[] a1 = {-1, 2, 8};

    for (int i = 0; i < a0.length; i++) {
        for (int j = 0; j < a1.length; j++) {
            System.out.print(a0[i] + a1[j] + ", ");
        }
    }

    }

    public static int fac(int x) {
        if (x > 1) {
            return x * fac(x - 1);
        } else {
            return 1;
        }

    }
}
