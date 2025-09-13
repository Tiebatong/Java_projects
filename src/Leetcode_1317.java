public class Leetcode_1317 {
    public static void main(String[] args) {

        int n = 11;

        int[] no_zero_integers = new int[2];

        int a = n / 2;
        int b = n - a;

        boolean zero = false;



        while (!zero && a < n && b > 1) {
            a++;
            b--;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
