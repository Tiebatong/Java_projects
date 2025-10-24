public class tmp {
    public static void main(String[] args) {



        for (int x = -10; x <= 10; x++) {
            System.out.println("f(" + x + ") = " + f(x));
        }

    }

    public static double f(int x) {
        return 5 + Math.sin(x);
    }
}
